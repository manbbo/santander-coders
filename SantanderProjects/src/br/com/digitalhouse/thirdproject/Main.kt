package br.com.digitalhouse.thirdproject

fun main() {
    val impressora = Impressora()
    impressora.addImprimivel(Foto("img.jpg", "FOTO"))
    impressora.addImprimivel(Documento("img.jpg", "DOCUMENTO"))
    impressora.addImprimivel(Contrato("img.jpg", "CONTRATO"))

    impressora.printAll()
}