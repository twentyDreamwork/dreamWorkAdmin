package dream.work.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.util.Base64Utils;


public class ImgUpload {

	private String photoPathStr = "http://39.108.143.92:8085/img";//测试环境
	
	private Constant conn=new Constant();

	/**
	 * 通用上传图片接口
	 * 
	 * @param base64DataList
	 * @return 图片路径
	 */
	public Results saveImg(List<String> base64DataList) {
		if (base64DataList.size() == 1) {// 单个图片的业务
			String base64Data = base64DataList.get(0);
			String dataPrix = "";
			String data = "";
			try {
				if (base64Data == null || "".equals(base64Data)) {
					return new Results(CommonCode.FAIL);
				}
				if (base64Data.indexOf(photoPathStr) != -1) {
					// 返回map对象返回名称+路径
					Map<String, Object> resultMap = new HashMap<String, Object>();
					String photoNameStr = base64Data.substring(photoPathStr.length());
					resultMap.put("photoName", photoNameStr);
					// 测试环境
					resultMap.put("photoPath", photoPathStr);
					return new Results(CommonCode.SUCCESS,resultMap);
				}
				base64Data = base64Data.replaceAll(" ", "+");
				String[] bases = base64Data.split("babamama");
				StringBuffer img = new StringBuffer();
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
				try {
					for (String base : bases) {
						if (base != null && !base.equals("")) {
							String[] d = base.split("base64,");
							if (d != null && d.length == 2) {
								dataPrix = d[0];
								data = d[1];
							}
							String suffix = "";
							if ("data:image/jpeg;".equalsIgnoreCase(dataPrix)) {// data:image/jpeg;base64,base64编码的jpeg图片数据
								suffix = ".jpeg";
							} else if ("data:image/x-icon;".equalsIgnoreCase(dataPrix)) {
								suffix = ".ico";
							} else if ("data:image/gif;".equalsIgnoreCase(dataPrix)) {
								suffix = ".gif";
							} else if ("data:image/png;".equalsIgnoreCase(dataPrix)) {
								suffix = ".png";
							} else {
								return new Results(CommonCode.FAIL);
							}
							Random random = new Random();
							String tempFileName = "/data/tomcat8085/radarImg/" + sdf2.format(new Date()) + "-"
									+ UUID.randomUUID() + suffix;
							byte[] bs = Base64Utils.decodeFromString(data);
							FileUtils.writeByteArrayToFile(new File(tempFileName), bs);
							String[] x = tempFileName.split("radarImg");
							// 返回map对象返回名称+路径
							Map<String, Object> resultMap = new HashMap<String, Object>();
							resultMap.put("photoName", x[1]);
							// 测试环境
							resultMap.put("photoPath", photoPathStr);
							return new Results(CommonCode.SUCCESS,resultMap);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					return new Results(CommonCode.FAIL);
				}

			} catch (Exception e) {
				e.printStackTrace();
				return new Results(CommonCode.FAIL);
			}
			return new Results(CommonCode.FAIL);
		} else if (base64DataList.size() > 1) { // 多个图片
			Map<String, Object> resultMap = new HashMap<String, Object>();
			List<Map<String, Object>> photoNameList = new ArrayList<>();
			resultMap.put("photoPath", photoPathStr);
			for (String base64Data : base64DataList) {
				String dataPrix = "";
				String data = "";
				try {
					if (base64Data == null || "".equals(base64Data)) {
						Map<String, Object> photoNameObj = new HashMap<>();
						photoNameObj.put("success", conn.fail);
						photoNameObj.put("errMsg", "上传失败");
						photoNameList.add(photoNameObj);
						continue;
					}
					if (base64Data.indexOf(photoPathStr) != -1) {
						// 生产环境
						Map<String, Object> photoNameObj = new HashMap<>();
						String photoNameStr = base64Data.substring(photoPathStr.length());
						photoNameObj.put("success", 1);
						photoNameObj.put("photoName", photoNameStr);
						photoNameList.add(photoNameObj);
						continue;
					}
					base64Data = base64Data.replaceAll(" ", "+");
					String base = base64Data;
					StringBuffer img = new StringBuffer();
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
					try {
						if (base != null && !base.equals("")) {
							String[] d = base.split("base64,");
							if (d != null && d.length == 2) {
								dataPrix = d[0];
								data = d[1];
							}
							String suffix = "";
							if ("data:image/jpeg;".equalsIgnoreCase(dataPrix)) {// data:image/jpeg;base64,base64编码的jpeg图片数据
								suffix = ".jpeg";
							} else if ("data:image/x-icon;".equalsIgnoreCase(dataPrix)) {
								suffix = ".ico";
							} else if ("data:image/gif;".equalsIgnoreCase(dataPrix)) {
								suffix = ".gif";
							} else if ("data:image/png;".equalsIgnoreCase(dataPrix)) {
								suffix = ".png";
							} else {
								Map<String, Object> photoNameObj = new HashMap<>();
								photoNameObj.put("success", conn.fail);
								photoNameObj.put("errMsg", "上传图片格式不合法");
								photoNameList.add(photoNameObj);
								continue;
							}
							Random random = new Random();
							String tempFileName = "/data/tomcat8085/radarImg/" + sdf2.format(new Date()) + "-"
									+ UUID.randomUUID() + suffix;
							byte[] bs = Base64Utils.decodeFromString(data);
							FileUtils.writeByteArrayToFile(new File(tempFileName), bs);
							String[] x = tempFileName.split("radarImg");
							// 生产环境
							Map<String, Object> photoNameObj = new HashMap<>();
							photoNameObj.put("success", conn.success);
							photoNameObj.put("photoName", x[1]);
							photoNameList.add(photoNameObj);
							continue;
						}

					} catch (Exception e) {
						e.printStackTrace();
						Map<String, Object> photoNameObj = new HashMap<>();
						photoNameObj.put("success", conn.fail);
						photoNameObj.put("errMsg", "上传失败");
						photoNameList.add(photoNameObj);
						continue;
					}

				} catch (Exception e) {
					e.printStackTrace();
					Map<String, Object> photoNameObj = new HashMap<>();
					photoNameObj.put("success", conn.fail);
					photoNameObj.put("errMsg", "上传失败");
					photoNameList.add(photoNameObj);
					continue;
				}
				Map<String, Object> photoNameObj = new HashMap<>();
				photoNameObj.put("success", conn.fail);
				photoNameObj.put("errMsg", "上传失败");
				photoNameList.add(photoNameObj);
				continue;
			}
			resultMap.put("photoNameList", photoNameList);
			return new Results(CommonCode.SUCCESS,resultMap);
		}
		return new Results(CommonCode.PARAM_ERROR);
	}
	
}
