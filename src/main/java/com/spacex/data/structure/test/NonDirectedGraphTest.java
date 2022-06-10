package com.spacex.data.structure.test;

import com.spacex.data.structure.graph.NonDirectedGraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class NonDirectedGraphTest {
    private NonDirectedGraph nonDirectedGraph;

    @BeforeEach
    public void init() {

    }

    @Test
    public void test() {
        String graphFilePath = NonDirectedGraphTest.class.getResource("/non-direct-graph.txt").getPath();
        String content = read(graphFilePath, null);

        this.nonDirectedGraph = new NonDirectedGraph(content);
        this.nonDirectedGraph.unweightedShortestPath();
        this.nonDirectedGraph.showDistance();
    }


    public static String read(final String filePath, final Integer spec) {
        File file = new File(filePath);
        // 当文件不存在或者不可读时
        if ((!isFileExists(file)) || (!file.canRead())) {
            System.out.println("file [" + filePath + "] is not exist or cannot read!!!");
            return null;
        }

        BufferedReader br = null;
        FileReader fb = null;
        StringBuffer sb = new StringBuffer();
        try {
            fb = new FileReader(file);
            br = new BufferedReader(fb);

            String str = null;
            int index = 0;
            while (((spec == null) || index++ < spec) && (str = br.readLine()) != null) {
                sb.append(str + "\n");
//                System.out.println(str);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(br);
            closeQuietly(fb);
        }

        return sb.toString();
    }

    /**
     * @param filePath 输出文件路径
     * @param content  要写入的内容
     * @param append   是否追加
     * @return
     */
    public static int write(final String filePath, final String content, final boolean append) {
        File file = new File(filePath);
        if (content == null) {
            System.out.println("file [" + filePath + "] invalid!!!");
            return 0;
        }

        // 当文件存在但不可写时
        if (isFileExists(file) && (!file.canRead())) {
            return 0;
        }

        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            if (!isFileExists(file)) {
                file.createNewFile();
            }

            fw = new FileWriter(file, append);
            bw = new BufferedWriter(fw);

            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        } finally {
            closeQuietly(bw);
            closeQuietly(fw);
        }

        return 1;
    }

    private static void closeQuietly(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException e) {
        }
    }

    private static boolean isFileExists(final File file) {
        if (file.exists() && file.isFile()) {
            return true;
        }
        return false;
    }

}
