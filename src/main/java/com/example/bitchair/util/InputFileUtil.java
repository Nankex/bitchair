package com.example.bitchair.util;

import com.example.bitchair.entity.Input;
import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

/**
 * @author nankex.
 * @data 2023/4/24.
 */
public class InputFileUtil {
    public List<String[]> tess() {
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
            System.out.println("allRows = " + allRows);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
        return allRows;
    }
}
