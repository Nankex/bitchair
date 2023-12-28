package com.example.bitchair.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import com.example.bitchair.entity.Input;
import com.example.bitchair.service.InputService;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author nankex.
 * @data 2023/4/17.
 */

public class InputTes{
    @Autowired
    InputService inputService;
    public void tess() {
        // 创建tsv解析器settings配置对象
        TsvParserSettings settings = new TsvParserSettings();
        //创建csv解析器settings配置对象
        //CsvParserSettings settings = new CsvParserSettings();
        // 文件中使用 '\n' 作为行分隔符
        // 确保像MacOS和Windows这样的系统,也可以正确处理（MacOS使用'\r'；Windows使用'\r\n'）
        settings.getFormat().setLineSeparator("\r\n");
        settings.setMaxCharsPerColumn(100000000);
        // 创建TSV解析器（将分隔符传入对象）
        TsvParser parser = new TsvParser(settings);
        // 创建CSV解析器（将分隔符传入对象）
        //CsvParser parser = new CsvParser(settings);
        // 对于csv文件,调用beginParsing逐个读取记录，使用迭代器iterator
        //parser.parseAll(new BufferedReader(new FileReader("tsv文件")));
        //System.out.println(parser.iterate(new File("")));
        //对tsv文件,调用parseAll
        List<String[]> allRows = null;
        try {
            allRows = parser.parseAll(new FileInputStream("G:\\新建文件夹 (3)\\项目\\毕业设计-比特币交易溯源系统\\blockchain数据\\blockchair_bitcoin_inputs\\blockchair_bitcoin_inputs_20230404.tsv\\blockchair_bitcoin_inputs_20230404.tsv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("allRows = " + allRows);
        Input input = new Input();
        for (int i = 1; i < allRows.size(); i++) {    //忽略第一行
            System.out.println("i = " + i);
            System.out.println(Arrays.asList(allRows.get(i)));
            input.setBlock_id(allRows.get(i)[0].trim());
            input.setTransaction_hash(allRows.get(i)[1].trim());
            input.setIndex(allRows.get(i)[2].trim());
            input.setTime(allRows.get(i)[3].trim());
            input.setValue(allRows.get(i)[4].trim());
            input.setValue_usd(allRows.get(i)[5].trim());
            input.setRecipient(allRows.get(i)[6].trim());
            input.setType(allRows.get(i)[7].trim());
            input.setScript_hex(allRows.get(i)[8].trim());
            input.setIs_from_coinbase(allRows.get(i)[9].trim());
            input.setIs_spendable(allRows.get(i)[10].trim());
            input.setSpending_block_id(allRows.get(i)[11].trim());
            input.setSpending_transaction_hash(allRows.get(i)[12].trim());
            input.setSpending_index(allRows.get(i)[13].trim());
            input.setSpending_time(allRows.get(i)[14].trim());
            input.setSpending_value_usd(allRows.get(i)[15].trim());
            input.setSpending_sequence(allRows.get(i)[16].trim());
            input.setSpending_signature_hex(allRows.get(i)[17].trim());
            input.setSpending_witness(allRows.get(i)[18].trim());
            input.setLifespan(allRows.get(i)[19].trim());
            input.setCdd(allRows.get(i)[20].trim());
            System.out.println("input = " + input);
            inputService.saveInput(input);
        }
		/*String[] row;
		while ((row = parser.parseNext()) != null) {
			System.out.println(row[0]);
			}*/

        // 在读取结束时自动关闭所有资源，
        // 或者当错误发生时，可以在任何使用调用stopParsing()

        // 只有在不是读取所有内容的情况下调用下面方法
        // 但如果不调用也没有非常严重的问题
        parser.stopParsing();
    }
}


