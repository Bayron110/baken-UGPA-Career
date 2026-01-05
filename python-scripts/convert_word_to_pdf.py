import sys
from docx import Document
from reportlab.lib.pagesizes import letter
from reportlab.pdfgen import canvas

def convert_word_to_pdf(word_file, pdf_file):
    # Abrir el documento Word
    doc = Document(word_file)

    # Crear un PDF con ReportLab
    c = canvas.Canvas(pdf_file, pagesize=letter)
    y = 750  # posición inicial en la página

    # Recorrer los párrafos del Word y escribirlos en el PDF
    for para in doc.paragraphs:
        text = para.text.strip()
        if text:
            c.drawString(100, y, text)
            y -= 20  # bajar la posición para la siguiente línea

            # Si llegamos al final de la página, crear una nueva
            if y < 50:
                c.showPage()
                y = 750

    c.save()

if __name__ == "__main__":
    # Recibir parámetros desde Spring Boot
    word_file = sys.argv[1]   # ruta del Word
    pdf_file = sys.argv[2]    # ruta del PDF de salida
    convert_word_to_pdf(word_file, pdf_file)