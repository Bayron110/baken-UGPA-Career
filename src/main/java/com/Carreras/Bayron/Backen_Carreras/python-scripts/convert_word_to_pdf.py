# python-scripts/convert_word_to_pdf.py
import sys
from docx import Document
from reportlab.lib.pagesizes import letter
from reportlab.pdfgen import canvas

def convert_word_to_pdf(word_file, pdf_file):
    try:
        # Abrir el documento Word
        doc = Document(word_file)

        # Crear un PDF con ReportLab
        c = canvas.Canvas(pdf_file, pagesize=letter)
        y = 750  # posición inicial en la página

        for para in doc.paragraphs:
            text = para.text.strip()
            if text:
                c.drawString(50, y, text)  # margen más seguro
                y -= 20
                if y < 50:
                    c.showPage()
                    y = 750

        c.save()
        print(f"PDF generado correctamente en {pdf_file}")
    except Exception as e:
        print("❌ Error al convertir Word a PDF:", e)
        sys.exit(1)

if __name__ == "__main__":
    if len(sys.argv) < 3:
        print("Uso: python convert_word_to_pdf.py <archivo.docx> <archivo.pdf>")
        sys.exit(1)
    convert_word_to_pdf(sys.argv[1], sys.argv[2])
