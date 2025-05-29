import java.io.IOException;
import java.io.OutputStream;
import java.io.DataOutputStream;

public class LivroOutputStream extends OutputStream {
    private Livro[] livros;
    private int numObjetosTransmitir;
    private int bytesPorAtributo;
    private OutputStream outputStream;

    public LivroOutputStream(Livro[] livros, int numObjetosTransmitir, 
                           int bytesPorAtributo, OutputStream outputStream) {
        this.livros = livros;
        this.numObjetosTransmitir = Math.min(numObjetosTransmitir, livros.length);
        this.bytesPorAtributo = bytesPorAtributo;
        this.outputStream = outputStream;
    }

    public void enviarDados() throws IOException {
        DataOutputStream dos = new DataOutputStream(outputStream);
        
        dos.writeInt(numObjetosTransmitir);
        
        for (int i = 0; i < numObjetosTransmitir; i++) {
            Livro livro = livros[i];
            
            writeFixedSizeString(dos, livro.getTitulo(), bytesPorAtributo);    
            writeFixedSizeString(dos, livro.getAutor(), bytesPorAtributo);      
            writeFixedSizeString(dos, livro.getEditora(), bytesPorAtributo);    
        }
        
        dos.flush();
    }

    private void writeFixedSizeString(DataOutputStream dos, String value, int size) throws IOException {
        byte[] bytes = value.getBytes("UTF-8");
        byte[] fixedSizeBytes = new byte[size];
        int length = Math.min(bytes.length, size);
        System.arraycopy(bytes, 0, fixedSizeBytes, 0, length);
        dos.write(fixedSizeBytes);
    }

    @Override
    public void write(int b) throws IOException {
        outputStream.write(b);
    }
}