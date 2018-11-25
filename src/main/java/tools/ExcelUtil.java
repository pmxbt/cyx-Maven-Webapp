package tools;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;

import com.base.bean.DealDeviceCost;
import com.base.bean.DealTrouble;

public class ExcelUtil {
	
	public static void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

	@SuppressWarnings("deprecation")
	public static HSSFWorkbook dcDealTrouble(DealTrouble dt) {
		   // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
    	HSSFWorkbook   wb = new HSSFWorkbook();
    	String rq = dt.getRq1().substring(0, 10);
		String dept_name = dt.getDept().getName();
		String fileName = rq+dept_name+"维修单";
    	
        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(rq+"维修单");

        sheet.setDefaultRowHeight((short) (30*20));
        sheet.setDefaultColumnWidth(20);
        // 第四步，创建单元格
        HSSFCellStyle style = wb.createCellStyle();
        style.setWrapText(true);   //自动换行
        
 
        style.setAlignment(HorizontalAlignment.CENTER);        // 水平对齐方式
    
        style.setVerticalAlignment(VerticalAlignment.CENTER);     // 垂直对齐方式

        Font baseFont = wb.createFont();       // 设置字体

        baseFont.setFontName("宋体");       // 字体类型
    
        baseFont.setFontHeightInPoints((short) 20);    // 字体大小
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);

        //声明列对象
        //HSSFCell cell = null;
	
		
        //1：开始行 2：结束行  3：开始列 4：结束列
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue(fileName);
        row.getCell(0).setCellStyle(style);
        
        HSSFRow row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("部门名称");
        row1.createCell(1).setCellValue(dt.getDept().getName());
        row1.createCell(2).setCellValue("创建人");
        row1.createCell(3).setCellValue(dt.getCreateUser().getName());
        row1.getCell(0).setCellStyle(style);
        row1.getCell(1).setCellStyle(style);
        row1.getCell(2).setCellStyle(style);
        row1.getCell(3).setCellStyle(style);
        
        
        
        
        HSSFRow row2 = sheet.createRow(2);
        sheet.addMergedRegion(new CellRangeAddress(2,2,1,3));
        row2.createCell(0).setCellValue("故障时间");
        row2.createCell(1).setCellValue(dt.getRq1());
        row2.getCell(0).setCellStyle(style);
        row2.getCell(1).setCellStyle(style);
		RegionUtil.setBorderBottom(1, new CellRangeAddress(2,2,1,3), sheet); // 下边框
		RegionUtil.setBorderLeft(1, new CellRangeAddress(2,2,1,3), sheet); // 左边框
		RegionUtil.setBorderRight(1, new CellRangeAddress(2,2,1,3), sheet); // 有边框
		RegionUtil.setBorderTop(1, new CellRangeAddress(2,2,1,3), sheet); // 上边框
        
        
        
        HSSFRow row3 = sheet.createRow(3);
        sheet.addMergedRegion(new CellRangeAddress(3,3,1,3));
        row3.createCell(0).setCellValue("故障描述");
        row3.createCell(1).setCellValue(dt.getRemark());
        row3.getCell(0).setCellStyle(style);
        row3.getCell(1).setCellStyle(style);
		
		// 使用RegionUtil类为合并后的单元格添加边框
		RegionUtil.setBorderBottom(1, new CellRangeAddress(3,3,1,3), sheet); // 下边框
		RegionUtil.setBorderLeft(1, new CellRangeAddress(3,3,1,3), sheet); // 左边框
		RegionUtil.setBorderRight(1, new CellRangeAddress(3,3,1,3), sheet); // 有边框
		RegionUtil.setBorderTop(1, new CellRangeAddress(3,3,1,3), sheet); // 上边框
        
        
        
        HSSFRow row4 = sheet.createRow(4);
        row4.createCell(0).setCellValue("委派维修人员");
        if(dt.getFixUser() != null){
        	row4.createCell(1).setCellValue(dt.getFixUser().getName());
        }else{
        	row4.createCell(1).setCellValue("");
        }
        row4.createCell(2).setCellValue("维修日期");
        row4.createCell(3).setCellValue(dt.getRq2());
        row4.getCell(0).setCellStyle(style);
        row4.getCell(1).setCellStyle(style);
        row4.getCell(2).setCellStyle(style);
        row4.getCell(3).setCellStyle(style);
        
        HSSFRow row5 = sheet.createRow(5);
        sheet.addMergedRegion(new CellRangeAddress(5,5,1,3));
        row5.createCell(0).setCellValue("故障原因");
        row5.createCell(1).setCellValue(dt.getReason());
        row5.getCell(0).setCellStyle(style);
        row5.getCell(1).setCellStyle(style);
        
		// 使用RegionUtil类为合并后的单元格添加边框
		RegionUtil.setBorderBottom(1, new CellRangeAddress(5, 5, 1, 3), sheet); // 下边框
		RegionUtil.setBorderLeft(1, new CellRangeAddress(5, 5, 1, 3), sheet); // 左边框
		RegionUtil.setBorderRight(1, new CellRangeAddress(5, 5, 1, 3), sheet); // 有边框
		RegionUtil.setBorderTop(1, new CellRangeAddress(5, 5, 1, 3), sheet); // 上边框
             
        
        HSSFRow row6 = sheet.createRow(6);
        row6.createCell(0).setCellValue("耗材类型");
        row6.createCell(1).setCellValue("耗材");
        row6.createCell(2).setCellValue("数量");
        row6.createCell(3).setCellValue("总计");
        row6.getCell(0).setCellStyle(style);
        row6.getCell(1).setCellStyle(style);
        row6.getCell(2).setCellStyle(style);
        row6.getCell(3).setCellStyle(style);
        
        List<DealDeviceCost> dclist = dt.getDeviceCost();
        int n = dclist.size();
        for (int i = 0; i < n; i++) {
        	HSSFRow row7 = sheet.createRow(7+i);
            row7.createCell(0).setCellValue(dclist.get(i).getDevice().getDeviceType().getName());
            row7.createCell(1).setCellValue(dclist.get(i).getDevice().getName());
            row7.createCell(2).setCellValue(dclist.get(i).getCount());
            row7.createCell(3).setCellValue(dclist.get(i).getTotalCost());
            row7.getCell(0).setCellStyle(style);
            row7.getCell(1).setCellStyle(style);
            row7.getCell(2).setCellStyle(style);
            row7.getCell(3).setCellStyle(style);
            
		}
        
        HSSFRow row8 = sheet.createRow(7+n);
        sheet.addMergedRegion(new CellRangeAddress(7+n,7+n,1,3));
        row8.createCell(0).setCellValue("共计");
        row8.createCell(1).setCellValue(dt.getTotalCost());
        row8.getCell(0).setCellStyle(style);
        row8.getCell(1).setCellStyle(style);
		// 使用RegionUtil类为合并后的单元格添加边框
		RegionUtil.setBorderBottom(1, new CellRangeAddress(7+n, 7+n, 1, 3), sheet); // 下边框
		RegionUtil.setBorderLeft(1, new CellRangeAddress(7+n, 7+n, 1, 3), sheet); // 左边框
		RegionUtil.setBorderRight(1, new CellRangeAddress(7+n, 7+n, 1, 3), sheet); // 有边框
		RegionUtil.setBorderTop(1, new CellRangeAddress(7+n, 7+n, 1, 3), sheet); // 上边框
             
        
        
        
        HSSFRow row9 = sheet.createRow(8+n);
        sheet.addMergedRegion(new CellRangeAddress(8+n,8+n,1,3));
        row9.createCell(0).setCellValue("回访");
        row9.createCell(1).setCellValue(dt.getVisitRemark());
        row9.getCell(0).setCellStyle(style);
        row9.getCell(1).setCellStyle(style);
		RegionUtil.setBorderBottom(1, new CellRangeAddress(8+n, 8+n, 1, 3), sheet); // 下边框
		RegionUtil.setBorderLeft(1, new CellRangeAddress(8+n, 8+n, 1, 3), sheet); // 左边框
		RegionUtil.setBorderRight(1, new CellRangeAddress(8+n, 8+n, 1, 3), sheet); // 有边框
		RegionUtil.setBorderTop(1, new CellRangeAddress(8+n, 8+n, 1, 3), sheet); // 上边框
        
        return wb;
	}
	
	
}
