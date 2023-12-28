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

import com.example.bitchair.entity.Block;
import com.example.bitchair.entity.Input;
import com.example.bitchair.service.BlockService;
import com.example.bitchair.service.InputService;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Part;

/**
 * @author nankex.
 * @data 2023/4/17.
 */

public class BlockTes{
    @Autowired
    BlockService blockService;
    public void tess(File file) {
        // 创建tsv解析器settings配置对象
        TsvParserSettings settings = new TsvParserSettings();
        //创建csv解析器settings配置对象
        //CsvParserSettings settings = new CsvParserSettings();
        // 文件中使用 '\n' 作为行分隔符
        // 确保像MacOS和Windows这样的系统,也可以正确处理（MacOS使用'\r'；Windows使用'\r\n'）
        settings.getFormat().setLineSeparator("\r\n");
//        settings.setMaxCharsPerColumn(100000000);
        // 创建TSV解析器（将分隔符传入对象）
        TsvParser parser = new TsvParser(settings);
        // 创建CSV解析器（将分隔符传入对象）
        //CsvParser parser = new CsvParser(settings);
        // 对于csv文件,调用beginParsing逐个读取记录，使用迭代器iterator
        //parser.parseAll(new BufferedReader(new FileReader("tsv文件")));
        //System.out.println(parser.iterate(new File("")));
        //对tsv文件,调用parseAll
        List<String[]> allRows = parser.parseAll(file);;
        //      List<String[]> allRows = null;
        //            allRows = parser.parseAll(new FileInputStream("G:\\新建文件夹 (3)\\项目\\毕业设计-比特币交易溯源系统\\blockchain数据\\blockchair_bitcoin_inputs\\blockchair_bitcoin_inputs_20230404.tsv\\blockchair_bitcoin_inputs_20230404.tsv"));
        System.out.println("allRows = " + allRows);
        Block block = new Block();
        for (int i = 1; i < allRows.size(); i++) {    //忽略第一行
            System.out.println("i = " + i);
            System.out.println(Arrays.asList(allRows.get(i)));
            block.setId(allRows.get(i)[0].trim());
            block.setHash(allRows.get(i)[1].trim());
            block.setTime(allRows.get(i)[2].trim());
            block.setMedian_time(allRows.get(i)[3].trim());
            block.setSize(allRows.get(i)[4].trim());
            block.setStripped_size(allRows.get(i)[5].trim());
            block.setWeight(allRows.get(i)[6].trim());
            block.setVersion(allRows.get(i)[7].trim());
            block.setVersion_hex(allRows.get(i)[8].trim());
            block.setVersion_bits(allRows.get(i)[9].trim());
            block.setMerkle_root(allRows.get(i)[10].trim());
            block.setNonce(allRows.get(i)[11].trim());
            block.setBits(allRows.get(i)[12].trim());
            block.setDifficulty(allRows.get(i)[13].trim());
            block.setChainwork(allRows.get(i)[14].trim());
            block.setCoinbase_data_hex(allRows.get(i)[15].trim());
            block.setTransaction_count(allRows.get(i)[16].trim());
            block.setWitness_count(allRows.get(i)[17].trim());
            block.setInput_count(allRows.get(i)[18].trim());
            block.setOutput_count(allRows.get(i)[19].trim());
            block.setInput_total(allRows.get(i)[20].trim());
            block.setInput_total_usd(allRows.get(i)[21].trim());
            block.setOutput_total(allRows.get(i)[22].trim());
            block.setOutput_total_usd(allRows.get(i)[23].trim());
            block.setFee_total(allRows.get(i)[24].trim());
            block.setFee_total_usd(allRows.get(i)[25].trim());
            block.setFee_per_kb(allRows.get(i)[26].trim());
            block.setFee_per_kb_usd(allRows.get(i)[27].trim());
            block.setFee_per_kwu(allRows.get(i)[28].trim());
            block.setFee_per_kwu_usd(allRows.get(i)[29].trim());
            block.setCdd_total(allRows.get(i)[30].trim());
            block.setGeneration(allRows.get(i)[31].trim());
            block.setGeneration_usd(allRows.get(i)[32].trim());
            block.setReward(allRows.get(i)[33].trim());
            block.setReward_usd(allRows.get(i)[34].trim());
            block.setGuessed_miner(allRows.get(i)[35].trim());
            blockService.saveBlock(block);
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


