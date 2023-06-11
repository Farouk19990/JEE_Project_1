package tn.iit.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
*/
import tn.iit.dao.AutorisationDao;
import tn.iit.dao.EnseignantDao;
import tn.iit.model.Autorisation;
import tn.iit.model.Enseignant;

/**
 * Servlet implementation class PDFGeneratorServlet
 */
@WebServlet("/PDFGeneratorServlet")
public class PDFGeneratorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PDFGeneratorServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {/*
		String idA = request.getParameter("pos");
		String idE = request.getParameter("idE");
		Autorisation a = AutorisationDao.findBytId(Integer.parseInt(idA));
		Enseignant e = EnseignantDao.findById(Integer.parseInt(idE));
		RequestDispatcher rdListUserView = getServletContext().getRequestDispatcher("/ListAutorisation.jsp");

		String teacherName = e.getName();

		String hours = Integer.toString(a.getNbheure());
		String dateAuto = a.getDate();
		// Get the current date
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String date = dateFormat.format(new Date());

		try (PDDocument document = new PDDocument()) {
			PDPage page = new PDPage(PDRectangle.A4);
			document.addPage(page);

			PDPageContentStream contentStream = new PDPageContentStream(document, page);

			// Add logo on the left
			URL logoUrl = new URL("https://iit.tn/wp-content/uploads/2019/06/logoISB1-1.png");
			try (InputStream logoInputStream = logoUrl.openStream()) {
				PDImageXObject logoImage = PDImageXObject.createFromByteArray(document,
						IOUtils.toByteArray(logoInputStream), "logo");
				int desiredWidth = 160;
				int desiredHeight = (int) ((double) desiredWidth / logoImage.getWidth() * logoImage.getHeight());
				contentStream.drawImage(logoImage, 50, 700, desiredWidth, desiredHeight);
			}

			// Add second image on the right
			URL secondImageUrl = new URL("https://www.atct.tn/sites/default/files/slogan_2.jpg");
			try (InputStream secondImageInputStream = secondImageUrl.openStream()) {
				PDImageXObject secondImage = PDImageXObject.createFromByteArray(document,
						IOUtils.toByteArray(secondImageInputStream), "second_image");
				int desiredWidth = 110;
				int desiredHeight = (int) ((double) desiredWidth / secondImage.getWidth() * secondImage.getHeight());
				contentStream.drawImage(secondImage, page.getMediaBox().getWidth() - 50 - desiredWidth, 700,
						desiredWidth, desiredHeight);
			}

			// Add header
			contentStream.beginText();

			String title = "Autorisation";
			int fontSize = 20;

			// Set font and font size
			contentStream.setFont(PDType1Font.HELVETICA_BOLD, fontSize);

			// Calculate the width of the title string
			float titleWidth = PDType1Font.HELVETICA_BOLD.getStringWidth(title) / 1000f * fontSize;

			// Calculate the horizontal position to center the title
			float startX = (page.getMediaBox().getWidth() - titleWidth) / 2;

			// Move to the starting position
			contentStream.moveTextPositionByAmount(startX, 700);

			// Write the centered title

			contentStream.showText(title);
			contentStream.endText();

			contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
			contentStream.beginText();
			contentStream.newLineAtOffset(400, 650);
			contentStream.showText("Sfax, Le " + date);
			contentStream.endText();
			// Add table
			float margin = 50;
			float yStart = 600;
			float tableWidth = page.getMediaBox().getWidth() - 2 * margin;
			float yPosition = yStart;
			float tableHeight = 100;
			float cellHeight = 20;
			float cellMargin = 5;

			// Draw table header
			drawTableCell(contentStream, margin, yPosition, tableWidth, cellHeight, "Enseignant", "Date",
					"Heures autoris�es");
			yPosition -= cellHeight;

			// Draw horizontal line

			// Draw table row with data
			drawTableCell(contentStream, margin, yPosition, tableWidth, cellHeight, teacherName, dateAuto, hours);

			// Add signature on the left
			contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
			contentStream.beginText();
			contentStream.newLineAtOffset(350, 200);
			contentStream.showText("Signature");
			contentStream.endText();
			contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
			contentStream.beginText();
			contentStream.newLineAtOffset(350, 180);
			contentStream.showText("Administration");
			contentStream.endText();
			contentStream.close();

			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=authorization.pdf");

			document.save(response.getOutputStream());
			document.close();
			HttpSession session = request.getSession();
			session.setAttribute("idE", idE);
			rdListUserView.forward(request, response);
		} catch (IOException eb) {
			eb.printStackTrace();
		}*/
	}
/*
	private void drawTableCell(PDPageContentStream contentStream, float x, float y, float width, float height,
			String... cellValues) throws IOException {
		float margin = 5;
		float tableWidth = width - 2 * margin;
		float tableHeight = height - 2 * margin;
		float cellWidth = tableWidth / (float) cellValues.length;
		float fontSize = 12;

		contentStream.setLineWidth(1f);
		contentStream.setFont(PDType1Font.HELVETICA_BOLD, fontSize);

		float textX = x + margin;
		float textY = y + margin + (tableHeight / 2f) - (fontSize / 2f);

		for (String cellValue : cellValues) {
			contentStream.beginText();
			contentStream.newLineAtOffset(textX, textY);
			contentStream.showText(cellValue);
			contentStream.endText();

			textX += cellWidth;
		}
	}*/

}
