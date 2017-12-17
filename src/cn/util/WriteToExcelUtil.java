package cn.util;

import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class WriteToExcelUtil {

	public static void write(String title[][], double context[][], int size[]) {
		// 操作执行
		try {
			// t.xls为要新建的文件名
			WritableWorkbook book = Workbook.createWorkbook(new File("排序.xls"));
			// 生成名为“第一页”的工作表，参数0表示这是第一页
			WritableSheet sheet = book.createSheet("第二题", 0);

			int len = context.length;
			// 写入内容
			int k = 0;
			int tj = 0;
			for (int i = 0; i < title[0].length; i++) { // title
				sheet.addCell(new Label(i, 0, title[0][i]));
			}
			k++;
			int l = 0;
			for (int i = k; i < 6; i++) { // context for
				for (int j = 0; j < context[k].length; j++) {
					sheet.addCell(new jxl.write.Number(j, i, context[l][j]));
				}
				l++;
			}
			for (int i = 0; i < title[0].length; i++) { // title
				sheet.addCell(new Label(i, 6, title[1][i]));
			}
			for (int i = 7; i < 12; i++) { // context for
				for (int j = 0; j < context[k].length; j++) {
					sheet.addCell(new jxl.write.Number(j, i, context[l][j]));
				}
				l++;
			}
			for (int i = 0; i < title[0].length; i++) { // title
				sheet.addCell(new Label(i, 12, title[2][i]));
			}
			for (int i = 13; i < 18; i++) { // context for
				for (int j = 0; j < context[k].length; j++) {
					sheet.addCell(new jxl.write.Number(j, i, context[l][j]));
				}
				l++;
			}
			for (int i = 0; i < title[0].length; i++) { // title
				sheet.addCell(new Label(i, 18, title[3][i]));
			}
			for (int i = 19; i < 24; i++) { // context for
				for (int j = 0; j < context[k].length; j++) {
					sheet.addCell(new jxl.write.Number(j, i, context[l][j]));
				}
				l++;
			}
			// 写入数据
			book.write();
			// 关闭文件
			book.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
