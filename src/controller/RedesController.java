package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	public void ip(String os) {

		String x[] = os.split(" ");
		for (int y = 0; y < x.length; y++) {
			if (x[y].equals("Windows")) {
				String cod = "cmd /c ipconfig";
				try {
					Process p = Runtime.getRuntime().exec(cod);
					InputStream fluxo = p.getInputStream();
					InputStreamReader leitor = new InputStreamReader(fluxo);
					BufferedReader buffer = new BufferedReader(leitor);
					String text = buffer.readLine();
					String pal[] = text.split(" ");
					for (int i = 0; i < pal.length; i++) {
						if (pal[i].equals("Adaptador")) {
							String adap = text;
							for (int j = 0; j < pal.length; j++) {
								if (pal[j].equals("IPv4.")) {
									System.out.println(adap);
									System.out.println(text);
									break;
								} else if (pal[j].equals("Adaptador")) {
									adap = text;
									text = buffer.readLine();
									pal = text.split(" ");
									j = -1;
								}
								if (j == (pal.length - 1)) {
									text = buffer.readLine();
									pal = text.split(" ");
									j = -1;
								}
							}
							text = buffer.readLine();
							pal = text.split(" ");
							i = -1;
						} else {
							text = buffer.readLine();
							if (text == null) {
								break;
							}
							pal = text.split(" ");
							i = -1;
						}
					}
					buffer.close();
					leitor.close();
					fluxo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void ping(String os) {
		String x[] = os.split(" ");
		for (int y = 0; y < x.length; y++) {
			if (x[y].equals("Windows")) {
				String codPing = "cmd /c ping -4 -n 10 www.uol.com.br";
				try {
					Process p = Runtime.getRuntime().exec(codPing);
					InputStream fluxo = p.getInputStream();
					InputStreamReader leitor = new InputStreamReader(fluxo);
					BufferedReader buffer = new BufferedReader(leitor);
					String text = buffer.readLine();
					String pal[] = text.split(" ");

					for (int j = 0; j < pal.length; j++) {
						if (pal[j].equals("Aproximar")) {
							text = buffer.readLine();
							pal = text.split(" ");
							System.out.println("ping medio:" + pal[pal.length-1]);
							break;
						}
						else if (j == (pal.length - 1)) {
							text = buffer.readLine();
							if (text == null) {
								break;
							}
							pal = text.split(" ");
							j = -1;
						}
					}
					buffer.close();
					leitor.close();
					fluxo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}