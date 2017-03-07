package com.dmooc.service.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VerifyCodeService {
	 private int width = 150;
	 private int height = 40;
	 private int fontHeight ;
	 // 验证码字符个数
	 private int codeCount = 4;
	 private int x = 0;
	 private int codeY;
	 char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
	  'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
	  'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	 
	 private void init(){
		 x = width / (codeCount + 1);
		 fontHeight = height - 2;
		 codeY = height - 4;
	 }
	 
	 public void createVerifyCodeImg(HttpServletRequest request,HttpServletResponse response){
		 init();
		// 定义图像buffer
		 BufferedImage buffImg = new BufferedImage(width, height,
		  BufferedImage.TYPE_INT_RGB);
		 Graphics2D g2d = buffImg.createGraphics();
		 
		 // 创建一个随机数生成器类
		 Random random = new Random();
		 
		 // 将图像填充为白色
		 g2d.setColor(Color.WHITE);
		 g2d.fillRect(0, 0, width, height);
		 
		 // 创建字体，字体的大小应该根据图片的高度来定。
		 Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);
		 // 设置字体。
		 g2d.setFont(font);
		 
		 // 画边框。
		 g2d.setColor(Color.BLACK);
		 g2d.drawRect(0, 0, width - 1, height - 1);
		 
		 // 随机产生160条干扰线，使图象中的认证码不易被其它程序探测到。
		 g2d.setColor(Color.BLACK);
		 for (int i = 0; i < 20; i++) {
		  int x = random.nextInt(width);
		  int y = random.nextInt(height);
		  int xl = random.nextInt(16);
		  int yl = random.nextInt(16);
		  g2d.drawLine(x, y, x + xl, y + yl);
		 }
		 
		 // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
		 StringBuffer randomCode = new StringBuffer();
		 int red = 0, green = 0, blue = 0;
		 
		 // 随机产生codeCount数字的验证码。
		 for (int i = 0; i < codeCount; i++) {
		  // 得到随机产生的验证码数字。
		  String strRand = String.valueOf(codeSequence[random.nextInt(36)]);
		  // 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
		  red = random.nextInt(255);
		  green = random.nextInt(255);
		  blue = random.nextInt(255);
		 
		  // 用随机产生的颜色将验证码绘制到图像中。
		  g2d.setColor(new Color(red, green, blue));
		  g2d.drawString(strRand, (i + 1) * x, codeY);
		 
		  // 将产生的四个随机数组合在一起。
		  randomCode.append(strRand);
		 }
		 // 将四位数字的验证码保存到Session中。
		 HttpSession session = request.getSession();
		 session.setAttribute("verifyCode", randomCode.toString());
		 
		 // 禁止图像缓存。
		 response.setHeader("Pragma", "no-cache");
		 response.setHeader("Cache-Control", "no-cache");
		 response.setDateHeader("Expires", 0);
		 
		 response.setContentType("image/jpeg");
		 
		 // 将图像输出到Servlet输出流中。
		 try{
		 ServletOutputStream sos = response.getOutputStream();
		 ImageIO.write(buffImg, "jpeg", sos);
		 sos.close();
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	 }

	public boolean verifyCode(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String answer = (String) session.getAttribute("verifyCode");
		String response = request.getParameter("response");
		System.out.println("answer : "+answer+" response : "+response);
		if(answer.equals(response))
			return true;
		else
			return false;
	}
}
