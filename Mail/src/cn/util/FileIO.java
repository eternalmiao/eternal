package cn.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
	
	
	public List<String> getContentFromFile(String fileName)
	{
		List<String> totalList = new ArrayList<String>();
		try
		{
			File file = new File(fileName);

			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gb2312"));
			String str;
			while ((str = br.readLine()) != null)
			{
				totalList.add(str.trim());
			}
			br.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return totalList;
	}

	
	public String getMail(String fileName)
	{
		StringBuilder mail = new StringBuilder();
		try
		{
			File file = new File(fileName);
			String str;
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gb2312"));
			while ((str = br.readLine()) != null)
			{
				mail.append(str.trim());
			}
			br.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return mail.toString();
	}
	
}
