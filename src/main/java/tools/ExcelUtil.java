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
		   // ��һ��������һ��HSSFWorkbook����Ӧһ��Excel�ļ�
    	HSSFWorkbook   wb = new HSSFWorkbook();
    	String rq = dt.getRq1().substring(0, 10);
		String dept_name = dt.getDept().getName();
		String fileName = rq+dept_name+"ά�޵�";
    	
        // �ڶ�������workbook�����һ��sheet,��ӦExcel�ļ��е�sheet
        HSSFSheet sheet = wb.createSheet(rq+"ά�޵�");

        sheet.setDefaultRowHeight((short) (30*20));
        sheet.setDefaultColumnWidth(20);
        // ���Ĳ���������Ԫ��
        HSSFCellStyle style = wb.createCellStyle();
        style.setWrapText(true);   //�Զ�����
        
 
        style.setAlignment(HorizontalAlignment.CENTER);        // ˮƽ���뷽ʽ
    
        style.setVerticalAlignment(VerticalAlignment.CENTER);     // ��ֱ���뷽ʽ

        Font baseFont = wb.createFont();       // ��������

        baseFont.setFontName("����");       // ��������
    
        baseFont.setFontHeightInPoints((short) 20);    // �����С
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);

        //�����ж���
        //HSSFCell cell = null;
	
		
        //1����ʼ�� 2��������  3����ʼ�� 4��������
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue(fileName);
        row.getCell(0).setCellStyle(style);
        
        HSSFRow row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("��������");
        row1.createCell(1).setCellValue(dt.getDept().getName());
        row1.createCell(2).setCellValue("������");
        row1.createCell(3).setCellValue(dt.getCreateUser().getName());
        row1.getCell(0).setCellStyle(style);
        row1.getCell(1).setCellStyle(style);
        row1.getCell(2).setCellStyle(style);
        row1.getCell(3).setCellStyle(style);
        
        
        
        
        HSSFRow row2 = sheet.createRow(2);
        sheet.addMergedRegion(new CellRangeAddress(2,2,1,3));
        row2.createCell(0).setCellValue("����ʱ��");
        row2.createCell(1).setCellValue(dt.getRq1());
        row2.getCell(0).setCellStyle(style);
        row2.getCell(1).setCellStyle(style);
		RegionUtil.setBorderBottom(1, new CellRangeAddress(2,2,1,3), sheet); // �±߿�
		RegionUtil.setBorderLeft(1, new CellRangeAddress(2,2,1,3), sheet); // ��߿�
		RegionUtil.setBorderRight(1, new CellRangeAddress(2,2,1,3), sheet); // �б߿�
		RegionUtil.setBorderTop(1, new CellRangeAddress(2,2,1,3), sheet); // �ϱ߿�
        
        
        
        HSSFRow row3 = sheet.createRow(3);
        sheet.addMergedRegion(new CellRangeAddress(3,3,1,3));
        row3.createCell(0).setCellValue("��������");
        row3.createCell(1).setCellValue(dt.getRemark());
        row3.getCell(0).setCellStyle(style);
        row3.getCell(1).setCellStyle(style);
		
		// ʹ��RegionUtil��Ϊ�ϲ���ĵ�Ԫ����ӱ߿�
		RegionUtil.setBorderBottom(1, new CellRangeAddress(3,3,1,3), sheet); // �±߿�
		RegionUtil.setBorderLeft(1, new CellRangeAddress(3,3,1,3), sheet); // ��߿�
		RegionUtil.setBorderRight(1, new CellRangeAddress(3,3,1,3), sheet); // �б߿�
		RegionUtil.setBorderTop(1, new CellRangeAddress(3,3,1,3), sheet); // �ϱ߿�
        
        
        
        HSSFRow row4 = sheet.createRow(4);
        row4.createCell(0).setCellValue("ί��ά����Ա");
        if(dt.getFixUser() != null){
        	row4.createCell(1).setCellValue(dt.getFixUser().getName());
        }else{
        	row4.createCell(1).setCellValue("");
        }
        row4.createCell(2).setCellValue("ά������");
        row4.createCell(3).setCellValue(dt.getRq2());
        row4.getCell(0).setCellStyle(style);
        row4.getCell(1).setCellStyle(style);
        row4.getCell(2).setCellStyle(style);
        row4.getCell(3).setCellStyle(style);
        
        HSSFRow row5 = sheet.createRow(5);
        sheet.addMergedRegion(new CellRangeAddress(5,5,1,3));
        row5.createCell(0).setCellValue("����ԭ��");
        row5.createCell(1).setCellValue(dt.getReason());
        row5.getCell(0).setCellStyle(style);
        row5.getCell(1).setCellStyle(style);
        
		// ʹ��RegionUtil��Ϊ�ϲ���ĵ�Ԫ����ӱ߿�
		RegionUtil.setBorderBottom(1, new CellRangeAddress(5, 5, 1, 3), sheet); // �±߿�
		RegionUtil.setBorderLeft(1, new CellRangeAddress(5, 5, 1, 3), sheet); // ��߿�
		RegionUtil.setBorderRight(1, new CellRangeAddress(5, 5, 1, 3), sheet); // �б߿�
		RegionUtil.setBorderTop(1, new CellRangeAddress(5, 5, 1, 3), sheet); // �ϱ߿�
             
        
        HSSFRow row6 = sheet.createRow(6);
        row6.createCell(0).setCellValue("�Ĳ�����");
        row6.createCell(1).setCellValue("�Ĳ�");
        row6.createCell(2).setCellValue("����");
        row6.createCell(3).setCellValue("�ܼ�");
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
        row8.createCell(0).setCellValue("����");
        row8.createCell(1).setCellValue(dt.getTotalCost());
        row8.getCell(0).setCellStyle(style);
        row8.getCell(1).setCellStyle(style);
		// ʹ��RegionUtil��Ϊ�ϲ���ĵ�Ԫ����ӱ߿�
		RegionUtil.setBorderBottom(1, new CellRangeAddress(7+n, 7+n, 1, 3), sheet); // �±߿�
		RegionUtil.setBorderLeft(1, new CellRangeAddress(7+n, 7+n, 1, 3), sheet); // ��߿�
		RegionUtil.setBorderRight(1, new CellRangeAddress(7+n, 7+n, 1, 3), sheet); // �б߿�
		RegionUtil.setBorderTop(1, new CellRangeAddress(7+n, 7+n, 1, 3), sheet); // �ϱ߿�
             
        
        
        
        HSSFRow row9 = sheet.createRow(8+n);
        sheet.addMergedRegion(new CellRangeAddress(8+n,8+n,1,3));
        row9.createCell(0).setCellValue("�ط�");
        row9.createCell(1).setCellValue(dt.getVisitRemark());
        row9.getCell(0).setCellStyle(style);
        row9.getCell(1).setCellStyle(style);
		RegionUtil.setBorderBottom(1, new CellRangeAddress(8+n, 8+n, 1, 3), sheet); // �±߿�
		RegionUtil.setBorderLeft(1, new CellRangeAddress(8+n, 8+n, 1, 3), sheet); // ��߿�
		RegionUtil.setBorderRight(1, new CellRangeAddress(8+n, 8+n, 1, 3), sheet); // �б߿�
		RegionUtil.setBorderTop(1, new CellRangeAddress(8+n, 8+n, 1, 3), sheet); // �ϱ߿�
        
        return wb;
	}
	
	
}
