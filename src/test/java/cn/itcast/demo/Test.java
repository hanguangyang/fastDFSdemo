package cn.itcast.demo;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
		// 1.加载配置文件
		ClientGlobal.init("F:\\eclipse-mars-205-pinyougou\\Workspaces\\fastDFSdemo\\src\\main\\resources\\fdfs_client.conf");
		// 2.构建一个管理者客户端
		TrackerClient client=new TrackerClient();
		// 3.连接管理者服务端
		TrackerServer trackerServer = client.getConnection();
		//4. 声明存储服务端
		StorageServer storageServer=null;
		//5. 获取存储服务器的客户端对象
		StorageClient storageClient=new StorageClient(trackerServer, storageServer);
		//6.上传文件
		String[] strings = storageClient.upload_file("D:\\Pictures\\banner\\banner1.jpg", "jpg", null);
		//7.显示上传结果 file_id
		for(String str:strings){
			System.out.println(str);
		}		
		
	}

}
