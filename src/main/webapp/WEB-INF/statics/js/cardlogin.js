var plugin = null;

function initPlugin() 
{ // 判断浏览器类型并加载相应的插件。若插件未安装，将弹出相应提示。
	var Sys = {};
	var ua = navigator.userAgent.toLowerCase();
	var s;
	(s = ua.match(/(msie\s|trident.*rv:)([\w.]+)/)) ? Sys.ie = s[1] :
	(s = ua.match(/firefox\/([\d.]+)/)) ? Sys.firefox = s[1] :
	(s = ua.match(/chrome\/([\d.]+)/)) ? Sys.chrome = s[1] :
	(s = ua.match(/opera.([\d.]+)/)) ? Sys.opera = s[1] :
	(s = ua.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0;

	if (Sys.ie) {
	//法一
	//	document.write('<object ID="plugin" WIDTH=0 HEIGHT=0 CLASSID="CLSID:7585D848-1BD6-4F8C-A32C-70E0A5C0F2F7"><PARAM NAME="_Version" VALUE="65536"><PARAM NAME="_ExtentX" VALUE="2646"><PARAM NAME="_ExtentY" VALUE="1323"><PARAM NAME="_StockProps" VALUE="0"></object><br />');
	// plugin = document.getElementById("plugin");
	//	if (plugin.object == null) { alert("插件未安装"); }
	
	//法二
		try {
			plugin = new ActiveXObject("SAMCLIENT.SamclientCtrl.1");
			return true;
		} catch(e) {
			alert("未找到插件。");
			return false;
		}
		
	} else {
		if (!navigator.plugins['Kingtrust Reader Plugin']) {
			alert("插件未安装。");
			return false;
		} else {
			jQuery('body').append('<object id="plugin" type="application/kingtrust-reader-plugin" width="0" height="0" ></object><br />');
			plugin = document.getElementById("plugin");
			return true;
		}
	}
}
		
{//	Error Code
var KTP_ERR_OK							= 0x00	// 正常
var KTP_ERR_INVAILD_PARAMETER			= 0x01	// 参数错误
var KTP_ERR_CANNOT_FOUND_READER			= 0x02	// 找不到读卡器
var KTP_ERR_CANNOT_FOUND_CARD			= 0x03	// 找不到二代证
var KTP_ERR_NETWORK_FAILED				= 0x04	// 网络链接故障
var KTP_ERR_DATA_PARSE					= 0x05	// 数据解析错误
var KTP_ERR_FRAME						= 0x06	// 应答帧错误
var KTP_ERR_UNHANDLED					= 0x07  // 未处理的错误。多半是该方法已出错而且未返回错误值
var KTP_ERR_RECHARGEDLL_FAILED			= 0x08  // 由充值库返回的错误。因错误类型定义过多，待将来再考虑处理。

var KTP_ERR_RECHARGE_NO_DEVICE			= 0x41	// 设备没找到
var KTP_ERR_RECHARGE_CARD_CONNECT		= 0x42	// 卡片未连接
var KTP_ERR_RECHARGE_MF_SELECT			= 0x43	// MF选择失败
var KTP_ERR_RECHARGE_DF_SELECT			= 0x44	// DF选择失败
var KTP_ERR_RECHARGE_PIN_INPUT			= 0x45	// PIN输入失败
var KTP_ERR_RECHARGE_VERIFY_PIN			= 0x46	// PIN验证失败
var KTP_ERR_RECHARGE_INITIALIZE			= 0x47	// 交易初始化失败
var KTP_ERR_RECHARGE_CREDIT				= 0x48	// 交易执行失败
var KTP_ERR_RECHARGE_SERVER_CONNECT		= 0x51	// 服务器连接失败
var KTP_ERR_RECHARGE_SEND				= 0x52	// 发送失败
var KTP_ERR_RECHARGE_RECEIVE			= 0x53	// 接收失败
var KTP_ERR_RECHARGE_GET_KEY_INDEX		= 0x54	// 获取密钥索引号失败
var KTP_ERR_RECHARGE_TRADE_REQUEST		= 0x55	// 交易请求失败
var KTP_ERR_RECHARGE_RESULT_UPLOAD		= 0x56	// 结果上传失败

var KTR_ERR_NO_RESPONSION				= 0xE0	//无应答      
var KTR_ERR_COMMUNICATION				= 0xE1	//通讯错误    
var KTR_ERR_FRAME						= 0xE2	//应答帧错误  
var KTR_ERR_PARAMETER					= 0xE3	//参数错误    
var KTR_ERR_CANNOT_EXECUTE				= 0xE4	//命令无法执行
var KTR_ERR_BUFFER_OVERFLOW				= 0xE5	//缓冲区溢出  
var KTR_ERR_MEMORY_NOT_ENOUGH			= 0xE6	//内存不足    
var KTR_ERR_BUFFER_NOT_ENOUGH			= 0xE7	//缓冲区不足  
}

var hReader = 0;
var gMifareAnticollisionUID = "";
var gMifareAnticollisionUIDLen = 0;
var gBlockNo = 1;

function showErrorMsg(errMsg) {
	alert(errMsg);
}

function getVersion() {
	var ver = plugin.GetVersion();
	var major = parseInt(ver/(256*256*256));
	ver = (ver - major * 256*256*256);
	var minor = parseInt(ver/(256*256));
	ver = (ver - minor * 256*256);
	var patch = parseInt(ver/(256));
	//strVersion.innerHTML = major + "." + minor + "." + patch;
}

function getDeviceSN() {
	var errorCode = plugin.GetDeviceSN();

	var error = '';
	// 此处错误处理仅处理了一部分，应根据上述错误代码进行合理的改动。
	switch(errorCode) {
	case KTP_ERR_CANNOT_FOUND_READER:
		showErrorMsg("未找到设备，请重新连接读卡器。");
		return false;
	case KTP_ERR_CANNOT_FOUND_CARD:
		showErrorMsg("未找到二代证。");
		return false;
	case KTP_ERR_OK:
		return plugin.DeviceSN;
	default:
		showErrorMsg("意外错误，请重试。错误代码：" + errorCode);
		return false;
	}
}

function getIDInformation() {
	if (getDeviceSN() == false) {
		return;
	}
	//	此处页面添加一个Loading效果
	var sa = 'www.ppbridge.com';
	var port = 9002
	var errorCode = plugin.GetIDInformation(sa, port);
	
	//	页面根据返回值处理结果，取消Loading效果
	
	// 此处错误处理仅处理了一部分，应根据上述错误代码进行合理的改动。
	switch(errorCode) {
	case KTP_ERR_CANNOT_FOUND_READER:
		alert("未找到设备，请重新连接读卡器。");
		return false;
	case KTP_ERR_CANNOT_FOUND_CARD:
		alert("未找到二代证。");
		return false;
	case KTP_ERR_NETWORK_FAILED:
		alert("网络通信错误，请检查服务器信息是否正确。");
		return false;
	case KTP_ERR_OK:
		break;
	default:
		alert("意外错误，请重试。错误代码：" + errorCode);
		return false;
	}
	
	var strID = plugin.ID;
	return strID;
}
