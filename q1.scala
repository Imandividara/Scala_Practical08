object CaesarCipher {

  // Function to encrypt a given text using Caesar Cipher
  def encrypt(text: String, shift: Int): String = {
    text.map { char =>
      if (char.isLetter) {
        val offset = if (char.isUpper) 'A' else 'a'
        ((char + shift - offset) % 26 + offset).toChar
      } else {
        char
      }
    }
  }

  // Function to decrypt a given text using Caesar Cipher
  def decrypt(text: String, shift: Int): String = {
    encrypt(text, 26 - shift)
  }

  // General cipher function to process the data using either encryption or decryption function
  def cipher(text: String, shift: Int, process: (String, Int) => String): String = {
    process(text, shift)
  }

  def main(args: Array[String]): Unit = {
    val originalText = "Hello, World!"
    val shift = 3

    // Encrypt the text
    val encryptedText = cipher(originalText, shift, encrypt)
    println(s"Encrypted Text: $encryptedText")

    // Decrypt the text
    val decryptedText = cipher(encryptedText, shift, decrypt)
    println(s"Decrypted Text: $decryptedText")
  }
}
