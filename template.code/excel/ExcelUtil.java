package com.bulu.fireworm.toolkit;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * @Author : chevysky
 */
public class ExcelUtil {

    static final String SUFFIX_XLSX = ".xlsx";
    static final String SUFFIX_XLS = ".xls";

    /**
     *  将上传的excel文件流解析,这里是处理后缀名为xls
     */
    public void analysisExcel(MultipartFile file)throws IOException{
        InputStream inputStream = file.getInputStream();
        //获取文件名,并根据后缀名判断调用的解析excel方法
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        switch (suffix){
            case SUFFIX_XLSX: analysisExcelXlsx(inputStream);break;
            case SUFFIX_XLS: analysisExcelXls(inputStream);break;
            default:
                System.out.println("请选择正确的excel格式:xlsx或xls");
        }

    }

    /**
     * 处理后缀为xlsx的excel
     * @param inputStream
     * @throws IOException
     */
    private void analysisExcelXlsx(InputStream inputStream)throws IOException{
        XSSFWorkbook sheets = new XSSFWorkbook(inputStream);
        for (Sheet sheet: sheets) {
            //获取行数
            int numberOfRows = sheet.getPhysicalNumberOfRows();
            ArrayList list = new ArrayList();
            for(int i = 0; i < numberOfRows; i++){
                Row row = sheet.getRow(i);
                //若出现了行为空则结束循环
                if (row == null){
                    break;
                }
                //遍历单元格,将每个单元格数据装入
                int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                Object[] obj = new Object[physicalNumberOfCells];
                for (int j = 0; j < physicalNumberOfCells; j++){
                   obj[j] = row.getCell(j);
                }
                list.add(obj);
            }
            System.out.println("输出数据" + list);
        }
    }

    /**
     * 处理后缀为xls的excel
     * @param inputStream
     * @throws IOException
     */
    private void analysisExcelXls(InputStream inputStream)throws IOException{
        POIFSFileSystem poifsFileSystem = new POIFSFileSystem(inputStream);
        HSSFWorkbook workbook = new HSSFWorkbook(poifsFileSystem);
        //获取一共有多少sheet
        int numberOfSheets = workbook.getNumberOfSheets();
        //循环处理每一个sheet
        for (int i = 0; i < numberOfSheets; i++){
            HSSFSheet sheet = workbook.getSheetAt(i);
            //获取sheet共有多少行
            int numberOfSheetRows = sheet.getPhysicalNumberOfRows();
            //将每一行的数据装入ArrayList中
            ArrayList list = new ArrayList();
            //遍历行
            for (int j = 0; j < numberOfSheetRows; j++){
                HSSFRow row = sheet.getRow(j);
                //如果行为空则结束循环
                if (row == null){
                    break;
                }
                //获取每一行有多少个单元格
                int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                //遍历将每一个单元格装入array
                Object[] obj = new Object[physicalNumberOfCells];
                for (int n = 0; n < physicalNumberOfCells; n++){
                    obj[n] = row.getCell(n);
                }
                list.add(obj);
            }
            System.out.println("输出数据：" + list);
        }
    }
}
