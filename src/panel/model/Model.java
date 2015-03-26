package panel.model;
import java.util.*;
import java.io.*;

;
public class Model {
	Pessoa pessoa;
	Sql sql;
	public Model(){
		sql = new Sql();
		
	}
	
	//----------------------------------------------------------
	public void setNome(String nome){
		System.out.println(nome);
	}
	public void setTel(String tel){
		System.out.println(tel);
	}
	public void setPos(String pos){
		System.out.println(pos);
	}
	
	//public void listar(String nome){
	public void listar(List<String> nomes)	{
		System.out.println("Teste: listar");
		sql.listarSql(nomes);
		
	}
	public void inserir(Pessoa p){
		sql.insertSql(p);
	}
	public String getTel(String nome){
		return sql.getSqlTel(nome);
	}
	public String getPos(String nome){
		return sql.getSqlPos(nome);
	
	}
	public void deletar(String nome){
		sql.deleteSql(nome);
	}
	public void montaHtml(String nome, String pos, String tel){
		String inicioHtml = "<!DOCTYPE html><html><head>"+ 
				"  <meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\" /> <title>Google Maps Multiple Markers</title>"+ 
				"<script src=\"http://maps.google.com/maps/api/js?sensor=false\"    type=\"text/javascript\"></script>"+
				"</head><body>  <div id=\"map\" style=\"width: 100%; height: 800px;\"></div>"+
				"<script type=\"text/javascript\">";
	//	String meioHtml = "var locations = [ ['teste', -21.890542, -44.274856, 4]];";
		String meioHtml = "var locations = [ ['"+nome+"("+tel+")', "+pos+"]];";

		String fimHtml = " var map = new google.maps.Map(document.getElementById(\'map\'), {      zoom: 17,      center: new google.maps.LatLng("+pos+"),"+
      "mapTypeId: google.maps.MapTypeId.ROADMAP    });    var infowindow = new google.maps.InfoWindow();"+
    "var marker, i; "+

    "for (i = 0; i < locations.length; i++) { "+ 
      "marker = new google.maps.Marker({"+
        "position: new google.maps.LatLng(locations[i][1], locations[i][2]), "+
        "map: map      });"+
      "google.maps.event.addListener(marker, 'click', (function(marker, i) {"+
        "return function() {"+
         " infowindow.setContent(locations[i][0]);"+
         " infowindow.open(map, marker);"+
        "}"+
      "})(marker, i));"+
    "}"+
  "</script>"+
"</body>"+
"</html>";
		String tudo = inicioHtml+meioHtml+fimHtml;
		System.out.print(meioHtml);
		try {
			PrintWriter out = new PrintWriter("mapa.html");
			out.print(tudo);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
