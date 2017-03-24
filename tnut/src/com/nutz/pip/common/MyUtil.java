package com.nutz.pip.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.nutz.utils.DateConvertUtil;

public class MyUtil {
	public static boolean isEmpty(String str) {
		boolean bool = false;
		if (str == null || str.length() == 0 || "".equals(str)) {
			bool = true;
		}
		return bool;
	}

	public static boolean isEmpty(Object obj) {
		boolean bool = false;
		if (obj == null)
			bool = true;
		return bool;
	}

	public static List getYearList() {
		List<String> list = new ArrayList<String>();
		for (int i = 2008; i < 2028; i++) {
			list.add(String.valueOf(i));
		}
		return list;
	}

	public static List getMonthList() {
		List<String> list = new ArrayList<String>();
		for (int i = 1; i <= 12; i++) {
			if(i<10){
				list.add("0"+String.valueOf(i));
			}else{
				list.add(String.valueOf(i));
			}			
		}
		return list;
	}

	public static int getYear() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new java.util.Date());
		int yy = calendar.get(Calendar.YEAR);
		return yy;
	}

	public static int getMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int mm = calendar.get(Calendar.MONTH) + 1;
		return mm;
	}

	public static String getThisYear() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new java.util.Date());
		int yy = calendar.get(Calendar.YEAR);
		String year = String.valueOf(yy);
		return year;
	}

	public static String getThisMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int mm = calendar.get(Calendar.MONTH) + 1;

		StringBuffer buf = new StringBuffer();
		if (mm < 10) {
			buf.append("0").append(mm);
		} else {
			buf.append(mm);
		}
		return buf.toString();
	}

	public static String getThisYearMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int yy = calendar.get(Calendar.YEAR);
		int mm = calendar.get(Calendar.MONTH) + 1;

		StringBuffer buf = new StringBuffer();
		buf.append(yy).append("-");
		if (mm < 10) {
			buf.append("0").append(mm);
		} else {
			buf.append(mm);
		}
		return buf.toString();
	}

	/**
	 * 得到上个月
	 * @return
	 */
	public static String getPreviousMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int mm = calendar.get(Calendar.MONTH);
		calendar.add(1, 1);

		StringBuffer buf = new StringBuffer();
		if (mm < 10) {
			buf.append("0").append(mm);
		} else {
			buf.append(mm);
		}
		return buf.toString();
	}
	
	/**
	 * 上一年
	 * @return
	 */
	public static String getPreviousYear() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int yy = calendar.get(Calendar.YEAR);
		return String.valueOf(yy-1);
	}

	public static String getFillMonthByDate() {
		StringBuffer buf = new StringBuffer();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new java.util.Date());
		int yy = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		buf.append(yy).append("-").append(month);
		return buf.toString();
	}

	public static String getFillPreviousMonthByDate() {
		StringBuffer buf = new StringBuffer();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new java.util.Date());
		int yy = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		buf.append(yy).append("-").append(month);
		return buf.toString();
	}

	/**
	 * �õ�ϵͳ�����ʱ��
	 * 
	 * @return
	 */
	public static String getCreateTime() {
		StringBuffer buf = new StringBuffer();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int yy = calendar.get(Calendar.YEAR);
		int MM = calendar.get(Calendar.MONTH) + 1;
		int dd = calendar.get(Calendar.DAY_OF_MONTH);
		int hh = calendar.get(Calendar.HOUR_OF_DAY);
		int mm = calendar.get(Calendar.MINUTE);
		int ss = calendar.get(Calendar.SECOND);
		buf.append(yy).append("-");
		buf.append(MM).append("-");
		buf.append(dd).append(" ");
		buf.append(hh).append(":");
		buf.append(mm).append(":");
		buf.append(ss);
		return buf.toString();
	}
	
	public static Date getCreateTime2() {
		StringBuffer buf = new StringBuffer();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int yy = calendar.get(Calendar.YEAR);
		int MM = calendar.get(Calendar.MONTH) + 1;
		int dd = calendar.get(Calendar.DAY_OF_MONTH);
		int hh = calendar.get(Calendar.HOUR_OF_DAY);
		int mm = calendar.get(Calendar.MINUTE);
		int ss = calendar.get(Calendar.SECOND);
		buf.append(yy).append("-");
		buf.append(MM).append("-");
		buf.append(dd).append(" ");
		buf.append(hh).append(":");
		buf.append(mm).append(":");
		buf.append(ss);
		String pattern = "";//默认为yyyy-MM-dd HH:mm:ss
		return DateConvertUtil.convertDate(buf.toString(), pattern);
	}

	public static Long getCurrentCode() {
		return System.currentTimeMillis();
	}

	/**
	 * �õ�ϵͳ���������
	 * 
	 * @return
	 */
	public static String getToday() {
		StringBuffer buf = new StringBuffer();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int yy = calendar.get(Calendar.YEAR);
		int mm = calendar.get(Calendar.MONTH) + 1;
		int dd = calendar.get(Calendar.DAY_OF_MONTH);

		buf.append(yy).append("-");
		if(mm < 10){
			buf.append("0").append(mm).append("-");
		}else{
			buf.append(mm).append("-");
		}
		
		buf.append(dd);
		return buf.toString();
	}

	@SuppressWarnings("unchecked")
	public static List getDisplayColumnList(List list, String key) {
		List ret = new ArrayList();
		int size = 0;
		if (StringUtils.isEmpty(key))
			return list;
		if (list != null && (size = list.size()) > 0) {
			String keys[] = key.split(",");
			int length = keys.length;
			for (int i = 0; i < size; i++) {
				String value = (String) list.get(i);
				for (int k = 0; k < length; k++) {
					String tem = keys[k];
					if (value.equals(tem)) {
						ret.add(list.get(i));
						break;
					}
				}
			}
		}
		return ret;
	}

	/**
	 * ����ܼ�¼�����ÿҳ��õ���ҳ��
	 * 
	 * @param tr
	 *            �ܼ�¼��
	 * @param ps
	 *            ÿҳ����
	 * @return
	 */
	public static int getTotalPages(int tr, int ps) {
		int tp = 1;
		if (tr < 1 || ps < 0)
			return tp;
		tp = (int) Math.ceil(tr / ps);
		// System.out.println(tr%ps);
		tp = (tr % ps) == 0 ? tp : ++tp;
		// System.out.println(tp);
		return tp;
	}

	/**
	 * 将class字段值封装到MAP集合中
	 * 
	 * @param obj
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchFieldException
	 */
	@SuppressWarnings("unchecked")
	public static Map getMapFromClass(Object obj) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException,
			NoSuchFieldException {
		Map map = new HashMap();
		Class cs = obj.getClass();
		Method mds[] = cs.getDeclaredMethods();
		for (Method md : mds) {
			String name = md.getName();
			if (name.startsWith("get")) {
				String key = name.substring(3).toLowerCase();
				// if (map.containsKey(key)) {
				Field fd = cs.getDeclaredField(key);
				// sObject type = fd.getType();
				Object obs[] = null;
				Object oo = md.invoke(obj, obs);
				if (oo != null)
					map.put(fd.getName(), oo);
				// }
			}
		}
		return map;
	}

	/**
	 * 根据页面封装 参数解析成map对象
	 * 
	 * @param map_params
	 * @param request
	 * @param pre_key =
	 *            "map";
	 * @return
	 */
	public static Map<String, String> getMapFromRequestParams(
			String map_params, HttpServletRequest request, String pre_key) {
		Map<String, String> map = new HashMap<String, String>();
		if (StringUtils.isNotEmpty(map_params)) {
			String params[] = map_params.split(",");
			// int length = params.length;
			for (String param : params) {
				if (StringUtils.isNotEmpty(param)) {
					String key = pre_key;
					if (StringUtils.isEmpty(key)) {
						key += "map";
					}
					String key1 = key.concat(".");
					if (param.startsWith(key1)) {
						key = param.substring(4);
					}
					String value = request.getParameter(param);
					map.put(key, value);
				}
			}
		}
		return map;
	}

	public static Vector getVectorFromRequestParams(String map_params,
			HttpServletRequest request, String pre_key) {
		Vector<String> pv = new Vector<String>();
		if (StringUtils.isNotEmpty(map_params)) {
			String params[] = map_params.split(",");
			// int length = params.length;
			for (String param : params) {
				if (StringUtils.isNotEmpty(param)) {
					String key = pre_key;
					if (StringUtils.isEmpty(key)) {
						key += "map";
					}
					String key1 = key.concat(".");
					if (param.startsWith(key1)) {
						key = param.substring(4);
					}
					String value = request.getParameter(param);
					// map.put(key,value);
					pv.addElement(value);
				}
			}
		}
		return pv;
	}

	/**
	 * 
	 * @param map_params
	 * @param request
	 * @param pre_key =
	 *            "list";
	 * @return
	 */
	public static List<Map> getMapListFromRequestParams(String map_params,
			String list_params, HttpServletRequest request, String pre_key) {
		List<Map> list = new ArrayList<Map>();
		Map<String, String> map = new HashMap<String, String>();
		if (StringUtils.isNotEmpty(map_params)) {
			String params[] = map_params.split(",");
			// int length = params.length;
			for (String param : params) {
				if (StringUtils.isNotEmpty(param)) {
					String key = pre_key;
					if (StringUtils.isEmpty(key)) {
						key += "map";
					}
					String key1 = key.concat(".");
					if (param.startsWith(key1)) {
						key = param.substring(4);
					}
					String value = request.getParameter(param);
					map.put(key, value);
				}
			}
		}

		if (StringUtils.isNotEmpty(list_params)) {
			String params[] = list_params.split(",");
			for (String param : params) {
				if (StringUtils.isNotEmpty(param)) {
					String key = "list";
					String key1 = key.concat(".");
					if (param.startsWith(key1)) {
						key = param.substring(4);
					}
					String values[] = request.getParameterValues(key);
					Map<String, String> map1 = new HashMap<String, String>();
					map1.putAll(map);
					for (String value : values) {
						map1.put(key, value);
						list.add(map1);
					}
				}
			}
		}

		return list;
	}

	public static float getMapSumByList(List<HashMap> list, String key) {
		float sum = 0f;
		if (list != null && list.size() > 0 && StringUtils.isNotEmpty(key)) {
			for (HashMap map : list) {
				String value = map.get(key) == null ? "0" : map.get(key)
						.toString();
				BigDecimal amount = new BigDecimal(value);
				sum += amount.floatValue();
			}
			// BigDecimal bd = new BigDecimal(sum);
			// bd.setScale(2,BigDecimal.ROUND_HALF_UP);
			// sum = bd.floatValue();

			DecimalFormat bdf = new DecimalFormat("#0.00");
			String value = bdf.format(sum);
			sum = new BigDecimal(value).floatValue();
		}
		return sum;
	}

	/**
	 * @author fwang 2010.08.15
	 * @param sql
	 * @param pv
	 * @return
	 */
	public static String wrapSqlParameters(String sql, Vector pv) {
		StringBuffer buf = new StringBuffer();
		if (pv == null || pv.size() == 0)
			return buf.toString();
		int size = pv.size();
		boolean isQuate = false;
		for (int i = 0; i < size; i++) {
			Object obj = pv.get(i);
			String value = obj.toString();
			if (value != null && value.length() > 0) {
				int dot = value.indexOf("?");
				if (dot > -1) {
					value = value.replace("?", "#");
					isQuate = true;
				}
			}
			// value = "'".concat(value).concat("'");
			sql = setSqlQuoteValue(sql, value);
		}
		if (isQuate) {
			sql = sql.replace("#", "?");
		}
		buf.append(sql);
		return buf.toString();
	}

	/**
	 * @author fwang 2010.08.15
	 * @param sql
	 * @param value
	 * @return
	 */
	public static String setSqlQuoteValue(String sql, String value) {
		if (sql == null || sql.length() == 0)
			return null;
		StringBuffer buf = new StringBuffer();
		int dot = 0;
		buf.setLength(0);
		dot = sql.indexOf("?");
		if (dot > -1) {
			buf.append(sql.substring(0, dot)).append(value).append(
					sql.substring(dot + 1));
			sql = buf.toString();
		}
		return buf.toString();
	}

	/**
	 * 哈希键值设置成小写
	 * 
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static HashMap toLowerCaseKeyHashMap(HashMap map) {
		HashMap hm = new HashMap();
		Set set = map.keySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			if (obj instanceof String) {
				String key = obj.toString().toLowerCase();
				hm.put(key, map.get(obj));
				// System.out.println("key="+key+"\t value="+obj);
			}
		}
		return hm;
	}

	@SuppressWarnings("unchecked")
	public static List toLowerCaseKeyList(List list) {
		List datas = new ArrayList();
		for (Object obj : list) {
			HashMap map = (HashMap) obj;
			map = toLowerCaseKeyHashMap(map);
			datas.add(map);
		}
		return datas;
	}

	/**
	 * 哈希键值设置成大写
	 * 
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static HashMap toUpperCaseKeyHashMap(HashMap map) {
		HashMap hm = new HashMap();
		Set set = map.keySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			if (obj instanceof String) {
				String key = obj.toString().toUpperCase();
				hm.put(key, map.get(obj));
				// System.out.println("key="+key+"\t value="+obj);
			}
		}
		return hm;
	}

	/**
	 * 字符是否数字，包括整型活小数
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isNumber(String value) {
		return NumberUtils.isNumber(value);
	}

	/**
	 * 检查中文字符长度字符
	 * 
	 * @param value
	 * @return
	 */
	public static int checkStrChLength(String value) {
		return value.getBytes().length;
	}

	/**
	 * 是否日期格式
	 * 
	 * @param strDate
	 * @param sign
	 * @return
	 */
	public static boolean isDate(String strDate, String sign) {
		boolean back = true;
		SimpleDateFormat sdf = new SimpleDateFormat(sign);
		try {
			sdf.parse(strDate);
		} catch (Exception e) {
			back = false;
		}
		return back;
	}

	/**
	 * 从全部字符集合和部分字符集合中查找不存在的字符数组
	 * 
	 * @param all
	 * @param ids
	 * @return
	 */
	public static String[] getNotExsitsElement(String all[], String ids[]) {
		String tem[] = new String[all.length];
		String tem1[] = new String[all.length];
		int count = 0;
		for (int i = 0; i < all.length; i++) {
			String str = all[i];
			boolean bool = false;
			for (int k = 0; k < ids.length; k++) {
				String str1 = ids[k];
				if (str.equals(str1)) {
					tem[i] = str1;
					bool = true;
					break;
				}
			}
			if (!bool) {
				tem1[i] = str;
				count++;
			}
		}

		String tem2[] = new String[count];
		int ind = 0;
		for (int i = 0; i < tem1.length; i++) {
			String str = tem1[i];
			if (str != null && str.length() > 0) {
				tem2[ind] = str;
			}
			ind++;
		}

		return tem2;
	}

	/**
	 * 设置实体BEAN字段信息到页面显示实体DTO(String)
	 * 
	 * @param bean
	 * @param dto
	 * @return
	 */
	public static Object setBeanToDto(Object bean, Object dto) {
		if (dto == null || bean == null)
			return null;
		Field fs[] = bean.getClass().getDeclaredFields();
		for (Field fd : fs) {
			String f_name = fd.getName();
			String f_type = fd.getType().getName();
			Field fd1 = null;
			try {
				fd1 = dto.getClass().getDeclaredField(f_name);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			}
			if (fd1 == null)
				return null;
			StringBuffer buf = new StringBuffer();
			if ("boolean".equals(f_type)) {
				if (f_name.startsWith("is")) {
					buf.append(f_name);
				} else {
					buf.append("is").append(MyUtil.getCapitalString(f_name));
				}
			} else {
				buf.append("get").append(MyUtil.getCapitalString(f_name));
			}
			String m_name = buf.toString();
			try {
				System.out.println(m_name);
				Class parameterTypes = null;// bean.getClass().getDeclaredField(f_name).getType();
				Method md = bean.getClass().getDeclaredMethod(m_name, null);

				parameterTypes = bean.getClass().getDeclaredField(f_name)
						.getType();
				Object obj = md.invoke(bean, null);
				if (obj == null)
					continue;
				String value = obj.toString();
				buf.setLength(0);
				buf.append("set").append(MyUtil.getCapitalString(f_name));
				m_name = buf.toString();
				parameterTypes = dto.getClass().getDeclaredField(f_name)
						.getType();
				md = dto.getClass().getDeclaredMethod(m_name, parameterTypes);
				md.invoke(dto, value);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	/**
	 * 设置实体BEAN字段信息到页面显示实体DTO(String) add by fwang 2010.10.24
	 * 
	 * @param dto
	 * @param bean
	 * @return
	 */
	public static Object setDtoToBean(Object dto, Object bean) {
		if (dto == null || bean == null)
			return null;
		Field fs[] = dto.getClass().getDeclaredFields();
		for (Field fd : fs) {
			String f_name = fd.getName();
			Field fd1 = null;
			try {
				fd1 = bean.getClass().getDeclaredField(f_name);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			}
			if (fd1 == null)
				return null;
			StringBuffer buf = new StringBuffer();
			buf.append("get").append(MyUtil.getCapitalString(f_name));
			String m_name = buf.toString();
			try {
				String f_type = bean.getClass().getDeclaredField(f_name)
						.getType().getName();
				// Class parameterTypes =
				// dto.getClass().getDeclaredField(f_name).getType();
				Method md = dto.getClass().getDeclaredMethod(m_name, null);
				// parameterTypes = null;
				Object obj = md.invoke(dto, null);
				if (obj == null)
					continue;
				String value = obj.toString();
				buf.setLength(0);
				buf.append("set").append(MyUtil.getCapitalString(f_name));
				m_name = buf.toString();

				if ("java.lang.Integer".equals(f_type) || "int".equals(f_type)) {// java.lang.Integer
					obj = Integer.parseInt(value);
				} else if ("java.lang.Long".equals(f_type)
						|| "long".equals(f_name)) {
					obj = Long.parseLong(value);
				} else if ("java.lang.Boolean".equals(f_type)
						|| "boolean".equals(f_type)) {
					if ("Y".equals(value) || "true".equals(value)) {
						obj = true;
					} else {
						obj = false;
					}
				} else if ("java.util.Date".equals(f_type)) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					try {
						obj = sdf.parse(value);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				} else if ("java.lang.Float".equals(f_type)
						|| "float".equals(f_type)) {
					obj = Float.parseFloat(value);
				} else if ("java.lang.Double".equals(f_type)
						|| "double".equals(f_type)) {
					obj = Double.parseDouble(value);
				} else if ("java.lang.String".equals(f_type)) {
					obj = value;
				} else {
					obj = value;
				}
				System.out.println("---------------------1 name:" + f_name
						+ "\t type:" + f_type);
				Class param = bean.getClass().getDeclaredField(f_name)
						.getType();
				md = bean.getClass().getDeclaredMethod(m_name, param);
				md.invoke(bean, obj);
				System.out.println("---------------------2 name:" + f_name
						+ "\t type:" + f_type);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			}
		}
		return bean;
	}

	public static void copyFieldValues(Object source, Object target) {
		if (source == null || target == null)
			return;
		Field fs[] = source.getClass().getDeclaredFields();
		for (Field fd : fs) {
			String f_name = fd.getName();
			Field fd1 = null;
			try {
				fd1 = target.getClass().getDeclaredField(f_name);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			}
			if (fd1 == null)
				return;
			try {
				String f_type = source.getClass().getDeclaredField(f_name)
						.getType().getName();
				StringBuffer buf = new StringBuffer();
				if ("boolean".equals(f_type)) {
					buf.append("is").append(MyUtil.getCapitalString(f_name));
				} else {
					buf.append("get").append(MyUtil.getCapitalString(f_name));
				}
				String m_name = buf.toString();
				// Class parameterTypes =
				// dto.getClass().getDeclaredField(f_name).getType();
				Method md = source.getClass().getDeclaredMethod(m_name, null);
				// parameterTypes = null;
				Object obj = md.invoke(source, null);
				if (obj == null)
					continue;
				String value = obj.toString();
				buf.setLength(0);
				buf.append("set").append(MyUtil.getCapitalString(f_name));
				m_name = buf.toString();
				f_type = fd1.getType().getName();

				if ("java.lang.Integer".equals(f_type) || "int".equals(f_type)) {// java.lang.Integer
					obj = Integer.parseInt(value);
				} else if ("java.lang.Long".equals(f_type)
						|| "long".equals(f_name)) {
					obj = Long.parseLong(value);
				} else if ("java.lang.Boolean".equals(f_type)
						|| "boolean".equals(f_type)) {
					if ("Y".equals(value) || "true".equals(value)) {
						obj = true;
					} else {
						obj = false;
					}
				} else if ("java.util.Date".equals(f_type)) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					try {
						obj = sdf.parse(value);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				} else if ("java.lang.Float".equals(f_type)
						|| "float".equals(f_type)) {
					obj = Float.parseFloat(value);
				} else if ("java.lang.Double".equals(f_type)
						|| "double".equals(f_type)) {
					obj = Double.parseDouble(value);
				} else if ("java.lang.String".equals(f_type)) {
					String target_type = target.getClass().getDeclaredField(
							f_name).getType().getName();
					if ("java.util.Date".equals(target_type)) {
						SimpleDateFormat sdf = new SimpleDateFormat(
								"yyyy-MM-dd");
						obj = sdf.format(obj);
					} else {
						obj = value;
					}

				} else {
					obj = value;
				}
				Class param = target.getClass().getDeclaredField(f_name)
						.getType();
				md = target.getClass().getDeclaredMethod(m_name, param);
				md.invoke(target, obj);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * add by fwang 2010.10.24
	 * 
	 * @param value
	 * @return
	 */
	public static String getCapitalString(String value) {
		StringBuffer buf = new StringBuffer();
		if (value != null && value.length() > 0) {
			buf.append(value.substring(0, 1).toUpperCase());
			buf.append(value.substring(1));
		}
		return buf.toString();
	}

	public static Date getDateFromString(String value) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse(value);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 将数组转换成过滤字符 如：
	 * {"001","002","003"} ==> ('001','002','003')
	 * @param strs
	 * @return
	 */
	public static String getIdsFromArray(String[] strs){
		StringBuffer buf = new StringBuffer();
		for(String str:strs){
			buf.append("'").append(str).append("',");
		}
		
		String result = buf.toString();
		if(result.endsWith(",")){
			buf.setLength(0);
			buf.append(result.substring(0,result.length()-1));
		}
		
		return buf.toString();
	}
	
	public static void main(String args[]){
		String strs[] = {"001","002","004","007"};
		String ids = MyUtil.getIdsFromArray(strs);
		System.out.println(ids);
	}
}
