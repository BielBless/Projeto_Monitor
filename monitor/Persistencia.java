package projeto.monitor;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class Persistencia {
	private static String nomeArquivo = "central.xml";
	private XStream xstream = new XStream(new DomDriver());
	
	public Persistencia() {
		xstream.addPermission(AnyTypePermission.ANY);
	}
	
	public void salvarCentral(CentralDeInformacoes centralDeInformacoes) {
		String xml = xstream.toXML(centralDeInformacoes);
		
		try {
			File arquivo = new File(nomeArquivo);
			arquivo.createNewFile();
			PrintWriter pw = new PrintWriter(arquivo);
			pw.print(xml);
			pw.close();
		} catch (IOException e) {
			System.out.println("ERRO");
		}
		
	}
	
	public CentralDeInformacoes recuperarCentral() {
		File arquivo = new File(nomeArquivo);
		if(arquivo.exists()) {
			CentralDeInformacoes central = (CentralDeInformacoes) xstream.fromXML(arquivo);
			return central;
		}else {
			return new CentralDeInformacoes();
		}
	}
	
}
