package com;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class MainTest {
	//错误的集合
	public static HashSet<String> errorContent =new HashSet<String>();
	//不需要检查的文件后缀名集合
	public static HashSet<String> rightLastFileName= new HashSet<String>();
	
	//需要检查的文件后缀名集合
	public static HashSet<String> errorLastFileName = new HashSet<String>();
	
	public static String result="";
    public static String path="";//扫描路径
	
	
	public static boolean  isCheckFlag = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				
				JFrame jf = new JFrame("代码冲突检查小工具");
		        jf.setSize(700, 800);
		        jf.setLocationRelativeTo(null);
		        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		        jf.setLocationRelativeTo(null);

		        JPanel panel = new JPanel();

		        
		        //--扫描地址--start
		        JLabel label_address = new JLabel("请输入扫描地址",JLabel.LEFT);
		        label_address.setFont(new Font(null, Font.PLAIN, 12));
		        panel.add(label_address);
		        
		        final JTextField textAddress = new JTextField(50);
		        textAddress.setFont(new Font(null, Font.PLAIN, 11));
		        textAddress.setText("/Users/mac/test");
		        panel.add(textAddress);
		        //--扫描地址--end
		        
		        
		        //--检查内容项--start
		        JLabel label_check = new JLabel();
		        label_check.setText("请输入检查项，以逗号分隔");
		        label_check.setFont(new Font(null, Font.PLAIN, 12));
		        panel.add(label_check);
		        
		        // 创建文本框，指定可见列数为16列
		        final JTextField textField = new JTextField(50);
		        textField.setFont(new Font(null, Font.PLAIN, 11));
		        textField.setText(">>>,<<<");
		        panel.add(textField);
		       // label_check.setBounds(100, 200, 300, 300);
		        
		        //--检查内容项--end
		        
		        //--后缀检查项--无须检查的文本和数据框--start
		        JLabel label_errorCheck = new JLabel();
		        label_errorCheck.setText("请输入无须检查的文件后缀，以逗号分隔");
		        label_errorCheck.setFont(new Font(null, Font.PLAIN, 12));
		        panel.add(label_errorCheck);
		        
		        // 创建文本框，指定可见列数为16列
		        final JTextField textError = new JTextField(45);
		        textError.setFont(new Font(null, Font.PLAIN, 11));
		        textError.setText("jar,jpg,html");
		        panel.add(textError);
		        //--后缀检查项--无须检查的文本和数据框--end
		        
		        //--后缀检查项--需要检查的后缀的文本和数据框--start
		        JLabel label_needCheck = new JLabel();
		        label_needCheck.setText("请输入需要检查的文件后缀，以逗号分隔");
		        label_needCheck.setFont(new Font(null, Font.PLAIN, 12));
		        panel.add(label_needCheck);
		        
		        // 创建文本框，指定可见列数为16列
		        final JTextField textNeedCheckText = new JTextField(45);
		        textNeedCheckText.setFont(new Font(null, Font.PLAIN, 11));
		        textNeedCheckText.setText("xml,class");
		        panel.add(textNeedCheckText);
		        //--后缀检查项--需要检查的后缀的文本和数据框--end
		        
		        
//		        //显示结果
//		        final  JTextArea showResult = new JTextArea();
//		        showResult.setFont(new Font(null, Font.PLAIN, 11)); 
//		        showResult.setVisible(true);
		        
		        
		        JLabel label01 = new JLabel();
		        label01.setSize(800, 800);
		        
		        label01.setText("");
		        label01.setFont(new Font(null, Font.PLAIN, 11));  // 设置字体，null 表示使用默认字体
		        label01.setVisible(true);
		    
		        
		
		        
		        
		        // 创建一个按钮，点击后获取文本框中的文本
		        JButton btn = new JButton("点击进行检查");
		        btn.setFont(new Font(null, Font.PLAIN, 20));
		        
		        panel.add(btn);
		        panel.add(label01);

		        jf.setContentPane(panel);
		        jf.setVisible(true);
		        
		       
		       
			//错误的集合
			errorContent.add(">>>");
			errorContent.add(">>>");
			
			//不需要检查的文件后缀名集合
			rightLastFileName.add("jar");
			rightLastFileName.add("jpg");
			rightLastFileName.add("png");
			rightLastFileName.add("rar");
			rightLastFileName.add("zip");
			rightLastFileName.add("png");
			
			
			//需要检查的文件后缀名集合
			errorLastFileName.add("xml");
			errorLastFileName.add("class");
			errorLastFileName.add("html");
			errorLastFileName.add("css");
			errorLastFileName.add("js");
			errorLastFileName.add("biz");
			errorLastFileName.add("txt");
			errorLastFileName.add("java");
			 btn.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	isCheckFlag =true;
		            	if(textAddress.getText().equals("")) {
		            		JOptionPane.showMessageDialog(
		                            jf,
		                            "请正确输入检查地址！",
		                            "通知",
		                            JOptionPane.INFORMATION_MESSAGE
		                    );
		            		isCheckFlag = false;
		            	}
		            	if(textField.getText().equals("")) {
		            		JOptionPane.showMessageDialog(
		                            jf,
		                            "请正确输入检查内容！",
		                            "通知",
		                            JOptionPane.INFORMATION_MESSAGE
		                    );
		            		isCheckFlag = false;
		            	}
		            	
		            	if(isCheckFlag) {
		            		 System.out.println("CHECK ADDRESS="+textAddress.getText());
	     		            	path = textAddress.getText();//检查地址
	     		            	 System.out.println("path  ="+path);
				               
				                File file = new File(path);		//获取其file对象
				    			if(isCheckFlag) {
				    				func(file);
				    			}
				    			 System.out.println("提交检查内容: " + textField.getText());
				    			 System.out.println("result= "+result);
				    			 label01.setText("<HTML>"+result+"</HTML>");
		            	}
		            }
		        });
			
		}
		//遍历文件夹下的所有文件
		private static void func(File file){
			result="";//初始化结果--清空
			File[] fs = file.listFiles();
			try {
			for(File f:fs){
				if(f.isDirectory())	//若是目录，则递归打印该目录下的文件
					func(f);
				else if(f.isFile())
				{
					//若是文件，直接打印
					//System.out.println("文件名称是 "+f);
					if(isCheckFile(f)) {
						readFileContent(f);
					}
					
				}
				
			} 
			}catch(Exception e ) {
				e.printStackTrace();
			}
		}
		//读取单个文件的内容
		public static void readFileContent(File file) {
			
			  StringBuilder result = new StringBuilder();
		        try{
		            BufferedReader br = new BufferedReader(
		            		new FileReader(file));//构造一个BufferedReader类来读取文件
		            String s = null;
		            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
		            	pipeiContent(file,s);//进行每行的匹配；
		                result.append(System.lineSeparator()+s);
		            }
		            br.close();    
		        }catch(Exception e){
		            e.printStackTrace();
		        }
			
		     
		        
		}
		
		//进行每行的匹配
		public static void pipeiContent(File file,String content) {
			
			Iterator it=  errorContent.iterator();
			while(it.hasNext()) {
				if(content.indexOf(it.next().toString())!=-1) {
					result+=
							"文件：<br>"+
					        file+
							"<br> 内容 ：<br>"+content+
							"<br>--------------------------<br>";
					System.out.println("文件："+file+" 有冲突 ："+content);
				}
				
			}
			
			
		}
		
		public static boolean isCheckFile(File f) {
			
			Iterator it = rightLastFileName.iterator();
			while(it.hasNext()) {
				if(f.getName().indexOf(it.next().toString())!=-1) {
					return false;
				}
			}
			
			Iterator it1 = errorLastFileName.iterator();
			while(it1.hasNext()) {
				if(f.getName().indexOf(it1.next().toString())!=-1) {
					return true;
				}
			}
			
			return false;	
		}
	}

