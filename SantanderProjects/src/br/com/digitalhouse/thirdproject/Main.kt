package br.com.digitalhouse.thirdproject

fun main() {
    //Primeiro jeito
    val impressora1 = Impressora()
    impressora1.addImprimivel(
            Foto("img.jpg", "JPG"),
            Documento("doc.docx", "DOCX"),
            Contrato("contrato.pdf", "PDF"))

    impressora1.printAll()

    //Segundo jeito
    val impressora2 = Impressora()
    val foto = Foto("img.jpg", "JPG")
    val doc = Documento("doc.docx", "DOCX")
    val contrato = Contrato("contrato.pdf", "PDF")

    impressora2.addImprimivel(foto, doc, contrato)

    impressora2.printAll()
}