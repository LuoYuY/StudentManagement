package manage.control;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import manage.model.NameScore;
import manage.model.Score;

@WebServlet("/exportServlet.do")
public class ExportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/vnd.ms-excel");
		OutputStream out = response.getOutputStream();
		
		String classtype=(String)request.getSession().getAttribute("classtype");
		
			if(classtype.equals("Score")) {
				ArrayList<Score> list = new ArrayList<Score>();
				list = (ArrayList<Score>)request.getSession().getAttribute("list");
				if(list!=null) {
					
					System.out.println("list.size()"+list.size());
					response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode("�ɼ�", "UTF-8"));
					Workbook workbook = new HSSFWorkbook();
					  //����������
					Sheet sheet = workbook.createSheet("�ɼ���");
					
					//������
					Row row = sheet.createRow(0);
					  //������Ԫ��
					Cell cell0 = row.createCell(0);
					  //���õ�һ�е�һ���ֵ
					cell0.setCellValue("ѧ��");
					Cell cell1 = row.createCell(1);
					  //���õ�һ�е�һ���ֵ
					cell1.setCellValue("�γ���");
					Cell cell2 = row.createCell(2);
					  //���õ�һ�е�һ���ֵ
					cell2.setCellValue("��ʦ��");
					Cell cell3 = row.createCell(3);
					  //���õ�һ�е�һ���ֵ
					cell3.setCellValue("�÷�");
					for(int i=0;i<list.size();i++) {
						Score score  = list.get(i);
						System.out.println("yes create a line");
						row = sheet.createRow(i+1);
						Cell c0 = row.createCell(0);
						c0.setCellValue(score.getLuoyy_term());
						Cell c1 = row.createCell(1);
						c1.setCellValue(score.getLuoyy_cname());
						Cell c2 = row.createCell(2);
						c2.setCellValue(score.getLuoyy_tname());
						Cell c3 = row.createCell(3);
						c3.setCellValue(score.getLuoyy_score());
					}
					  workbook.write(out);
					 
					  out.flush();
					  out.close();
				}
				else {
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/student/queryMyScore.jsp");
					rd.forward(request, response);
				}
			}
			else
			{
				
				ArrayList<NameScore> list = new ArrayList<NameScore>();
				list = (ArrayList<NameScore>)request.getSession().getAttribute("list");
				if(list!=null) {

					System.out.println("list.size()"+list.size());
					response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode("����.xlsx", "UTF-8"));
					Workbook workbook = new HSSFWorkbook();
					  //����������
					Sheet sheet = workbook.createSheet("������");
					
					//������
					Row row = sheet.createRow(0);
					  //������Ԫ��
					Cell cell0 = row.createCell(0);
					  //���õ�һ�е�һ���ֵ
					cell0.setCellValue("ѧ��");
					Cell cell1 = row.createCell(1);
					  //���õ�һ�е�һ���ֵ
					cell1.setCellValue("����");
					Cell cell2 = row.createCell(2);
					  //���õ�һ�е�һ���ֵ
					cell2.setCellValue(" ");
				
					for(int i=0;i<list.size();i++) {
						NameScore namescore  = list.get(i);
						row = sheet.createRow(i+1);
						Cell c0 = row.createCell(0);
						c0.setCellValue(namescore.getLuoyy_sno());
						Cell c1 = row.createCell(1);
						c1.setCellValue(namescore.getLuoyy_sname());
						if(namescore.getLuoyy_score()!=0) {
							Cell c2 = row.createCell(2);
							c2.setCellValue(namescore.getLuoyy_score());
						}
					}
					  workbook.write(out);
					 
					  out.flush();
					  out.close();
				}
				else {
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/student/queryReports.jsp");
					rd.forward(request, response);
				}
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
