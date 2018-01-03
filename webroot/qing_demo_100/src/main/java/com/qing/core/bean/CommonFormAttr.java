package com.qing.core.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @description 表单公共属性
 * 
 * @author 谢进伟
 * 
 * @createDate 2016年4月9日 下午2:19:36
 */
public class CommonFormAttr {
	
	/** 表单元素type属性 **/
	private String type;
	/** 规定元素的一个或多个类名（引用样式表中的类）。 **/
	private String _class;
	/** 表单元素的Id属性 **/
	private String id;
	/** 表单元素的name属性 **/
	private String name;
	/** 规定鼠标悬浮式的提示信息 **/
	private String title;
	/** 元素的默认值 **/
	private String value;
	/** 规定元素的行内 CSS 样式。 **/
	private String style;
	/** 表单元素是否只读 **/
	private String readonly;
	/** 如果使用该属性，则允许一个以上的值。 **/
	private String multiple;
	/** 表单元素是否禁用 **/
	private String disabled;
	/** 输入字段的宽度 **/
	private String size;
	/** 定义 input 字段的高度。（适用于 type="image"） **/
	private String height;
	/** 定义 input 字段的宽度。（适用于 type="image"） **/
	private String width;
	/** 不赞成使用。规定图像输入的对齐方式。left,right,top,middle,bottom **/
	private String align;
	/** 定义图像输入的替代文本。 **/
	private String alt;
	/** 定义以提交按钮形式显示的图像的 URL。 **/
	private String src;
	/** 指示输入字段的值是必需的。 **/
	private String required;
	/** 覆盖表单的 novalidate 属性。如果使用该属性，则提交表单时不进行验证。 **/
	private String formnovalidate;
	/** 规定元素内容的语言。 **/
	private String lang;
	/** 规定输入字段的值的模式或格式。例如 pattern="[0-9]" 表示输入值必须是 0 与 9 之间的数字。 **/
	private String pattern;
	/** 规定输入字段的最小值。请与 "max" 属性配合使用，来创建合法值的范围。 **/
	private String min;
	/** 规定输入字段的最大值。 请与 "min" 属性配合使用，来创建合法值的范围。 **/
	private String max;
	/** 规定输入字段所属的一个或多个表单。 **/
	private String form;
	/** 规定元素仍未或不再相关。 **/
	private String hidden;
	/** 规定输入字段中的字符的最大长度。 **/
	private String maxlength;
	/** 覆盖表单的 enctype 属性。（适用于 type="submit" 和 type="image"） **/
	private String formenctype;
	/** 规定激活元素的快捷键。 **/
	private String accesskey;
	/** 规定是否使用输入字段的自动完成功能。 **/
	private String autocomplete;
	/** 规定帮助用户填写输入字段的提示。 **/
	private String placeholder;
	/** 规定在拖动被拖动数据时是否进行复制、移动或链接。 **/
	private String dropzone;
	/** 规定元素中内容的文本方向。 **/
	private String dir;
	/** 用于存储页面或应用程序的私有定制数据。 **/
	private String data_x;
	/** 规定是否应该翻译元素内容。 **/
	private String translate;
	/** 规定元素内容是否可编辑。 **/
	private String contenteditable;
	/** 规定输入字段在页面加载时是否获得焦点。 （不适用于 type="hidden"） **/
	private String autofocus;
	/** 引用包含输入字段的预定义选项的 datalist 。 **/
	private String list;
	/** 覆盖表单的 method 属性。（适用于 type="submit" 和 type="image"） **/
	private String formmethod;
	/** 覆盖表单的 action 属性。（适用于 type="submit" 和 type="image"） **/
	private String formaction;
	/** 覆盖表单的 target 属性（适用于 type="submit" 和 type="image"） **/
	private String formtarget;
	/** 规定元素的上下文菜单。上下文菜单在用户点击元素时显示。 **/
	private String contextmenu;
	/** 规定此 input 元素首次加载时应当被选中。 **/
	private String checked;
	/** 规定是否对元素进行拼写和语法检查。 **/
	private String spellcheck;
	/** 规定元素是否可拖动。 **/
	private String draggable;
	/** 规定通过文件上传来提交的文件的类型。 **/
	private String accept;
	/** 规定元素的 tab 键次序。 **/
	private String tabindex;
	/** 规定输入字的的合法数字间隔。 **/
	private String step;
	/** 自定义属性 **/
	private Map<String , String> customAttr = new HashMap<String , String>();
	
	/** 表单元素type属性 **/
	public String getType() {
		return this.type;
	}
	
	/** 表单元素type属性 **/
	public void setType(String type) {
		this.type = type;
	}
	
	/** 规定元素的一个或多个类名（引用样式表中的类）。 **/
	public String get_class() {
		return this._class;
	}
	
	/** 规定元素的一个或多个类名（引用样式表中的类）。 **/
	public void set_class(String _class) {
		this._class = _class;
	}
	
	/** 表单元素的Id属性 **/
	public String getId() {
		return this.id;
	}
	
	/** 表单元素的Id属性 **/
	public void setId(String id) {
		this.id = id;
	}
	
	/** 表单元素的name属性 **/
	public String getName() {
		return this.name;
	}
	
	/** 表单元素的name属性 **/
	public void setName(String name) {
		this.name = name;
	}
	
	/** 规定鼠标悬浮式的提示信息 **/
	public String getTitle() {
		return this.title;
	}
	
	/** 规定鼠标悬浮式的提示信息 **/
	public void setTitle(String title) {
		this.title = title;
	}
	
	/** 元素的默认值 **/
	public String getValue() {
		return this.value;
	}
	
	/** 元素的默认值 **/
	public void setValue(String value) {
		this.value = value;
	}
	
	/** 规定元素的行内 CSS 样式。 **/
	public String getStyle() {
		return this.style;
	}
	
	/** 规定元素的行内 CSS 样式。 **/
	public void setStyle(String style) {
		this.style = style;
	}
	
	/** 表单元素是否只读 **/
	public String getReadonly() {
		return this.readonly;
	}
	
	/** 表单元素是否只读 **/
	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}
	
	/** 如果使用该属性，则允许一个以上的值。 **/
	public String getMultiple() {
		return this.multiple;
	}
	
	/** 如果使用该属性，则允许一个以上的值。 **/
	public void setMultiple(String multiple) {
		this.multiple = multiple;
	}
	
	/** 表单元素是否禁用 **/
	public String getDisabled() {
		return this.disabled;
	}
	
	/** 表单元素是否禁用 **/
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}
	
	/** 输入字段的宽度 **/
	public String getSize() {
		return this.size;
	}
	
	/** 输入字段的宽度 **/
	public void setSize(String size) {
		this.size = size;
	}
	
	/** 定义 input 字段的高度。（适用于 type="image"） **/
	public String getHeight() {
		return this.height;
	}
	
	/** 定义 input 字段的高度。（适用于 type="image"） **/
	public void setHeight(String height) {
		this.height = height;
	}
	
	/** 定义 input 字段的宽度。（适用于 type="image"） **/
	public String getWidth() {
		return this.width;
	}
	
	/** 定义 input 字段的宽度。（适用于 type="image"） **/
	public void setWidth(String width) {
		this.width = width;
	}
	
	/** 不赞成使用。规定图像输入的对齐方式。left,right,top,middle,bottom **/
	public String getAlign() {
		return this.align;
	}
	
	/** 不赞成使用。规定图像输入的对齐方式。left,right,top,middle,bottom **/
	public void setAlign(String align) {
		this.align = align;
	}
	
	/** 定义图像输入的替代文本。 **/
	public String getAlt() {
		return this.alt;
	}
	
	/** 定义图像输入的替代文本。 **/
	public void setAlt(String alt) {
		this.alt = alt;
	}
	
	/** 定义以提交按钮形式显示的图像的 URL。 **/
	public String getSrc() {
		return this.src;
	}
	
	/** 定义以提交按钮形式显示的图像的 URL。 **/
	public void setSrc(String src) {
		this.src = src;
	}
	
	/** 指示输入字段的值是必需的。 **/
	public String getRequired() {
		return this.required;
	}
	
	/** 指示输入字段的值是必需的。 **/
	public void setRequired(String required) {
		this.required = required;
	}
	
	/**
	 * 覆盖表单的 novalidate 属性。
	 * 如果使用该属性，则提交表单时不进行验证。
	 **/
	
	public String getFormnovalidate() {
		return this.formnovalidate;
	}
	
	/**
	 * 覆盖表单的 novalidate 属性。
	 * 如果使用该属性，则提交表单时不进行验证。
	 **/
	
	public void setFormnovalidate(String formnovalidate) {
		this.formnovalidate = formnovalidate;
	}
	
	/** 规定元素内容的语言。 **/
	public String getLang() {
		return this.lang;
	}
	
	/** 规定元素内容的语言。 **/
	public void setLang(String lang) {
		this.lang = lang;
	}
	
	/**
	 * 规定输入字段的值的模式或格式。
	 * 例如 pattern="[0-9]" 表示输入值必须是 0 与 9 之间的数字。
	 **/
	
	public String getPattern() {
		return this.pattern;
	}
	
	/**
	 * 规定输入字段的值的模式或格式。
	 * 例如 pattern="[0-9]" 表示输入值必须是 0 与 9 之间的数字。
	 **/
	
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
	/**
	 * 规定输入字段的最小值。
	 * 请与 "max" 属性配合使用，来创建合法值的范围。
	 **/
	
	public String getMin() {
		return this.min;
	}
	
	/**
	 * 规定输入字段的最小值。
	 * 请与 "max" 属性配合使用，来创建合法值的范围。
	 **/
	
	public void setMin(String min) {
		this.min = min;
	}
	
	/**
	 * 规定输入字段的最大值。
	 * 请与 "min" 属性配合使用，来创建合法值的范围。
	 **/
	
	public String getMax() {
		return this.max;
	}
	
	/**
	 * 规定输入字段的最大值。
	 * 请与 "min" 属性配合使用，来创建合法值的范围。
	 **/
	
	public void setMax(String max) {
		this.max = max;
	}
	
	/** 规定输入字段所属的一个或多个表单。 **/
	public String getForm() {
		return this.form;
	}
	
	/** 规定输入字段所属的一个或多个表单。 **/
	public void setForm(String form) {
		this.form = form;
	}
	
	/** 规定元素仍未或不再相关。 **/
	public String getHidden() {
		return this.hidden;
	}
	
	/** 规定元素仍未或不再相关。 **/
	public void setHidden(String hidden) {
		this.hidden = hidden;
	}
	
	/** 规定输入字段中的字符的最大长度。 **/
	public String getMaxlength() {
		return this.maxlength;
	}
	
	/** 规定输入字段中的字符的最大长度。 **/
	public void setMaxlength(String maxlength) {
		this.maxlength = maxlength;
	}
	
	/**
	 * 覆盖表单的 enctype 属性。
	 * （适用于 type="submit" 和 type="image"）
	 **/
	
	public String getFormenctype() {
		return this.formenctype;
	}
	
	/**
	 * 覆盖表单的 enctype 属性。
	 * （适用于 type="submit" 和 type="image"）
	 **/
	
	public void setFormenctype(String formenctype) {
		this.formenctype = formenctype;
	}
	
	/** 规定激活元素的快捷键。 **/
	public String getAccesskey() {
		return this.accesskey;
	}
	
	/** 规定激活元素的快捷键。 **/
	public void setAccesskey(String accesskey) {
		this.accesskey = accesskey;
	}
	
	/** 规定是否使用输入字段的自动完成功能。 **/
	public String getAutocomplete() {
		return this.autocomplete;
	}
	
	/** 规定是否使用输入字段的自动完成功能。 **/
	public void setAutocomplete(String autocomplete) {
		this.autocomplete = autocomplete;
	}
	
	/** 规定帮助用户填写输入字段的提示。 **/
	public String getPlaceholder() {
		return this.placeholder;
	}
	
	/** 规定帮助用户填写输入字段的提示。 **/
	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}
	
	/** 规定在拖动被拖动数据时是否进行复制、移动或链接。 **/
	public String getDropzone() {
		return this.dropzone;
	}
	
	/** 规定在拖动被拖动数据时是否进行复制、移动或链接。 **/
	public void setDropzone(String dropzone) {
		this.dropzone = dropzone;
	}
	
	/** 规定元素中内容的文本方向。 **/
	public String getDir() {
		return this.dir;
	}
	
	/** 规定元素中内容的文本方向。 **/
	public void setDir(String dir) {
		this.dir = dir;
	}
	
	/** 用于存储页面或应用程序的私有定制数据。 **/
	public String getData_x() {
		return this.data_x;
	}
	
	/** 用于存储页面或应用程序的私有定制数据。 **/
	public void setData_x(String data_x) {
		this.data_x = data_x;
	}
	
	/** 规定是否应该翻译元素内容。 **/
	public String getTranslate() {
		return this.translate;
	}
	
	/** 规定是否应该翻译元素内容。 **/
	public void setTranslate(String translate) {
		this.translate = translate;
	}
	
	/** 规定元素内容是否可编辑。 **/
	public String getContenteditable() {
		return this.contenteditable;
	}
	
	/** 规定元素内容是否可编辑。 **/
	public void setContenteditable(String contenteditable) {
		this.contenteditable = contenteditable;
	}
	
	/**
	 * 规定输入字段在页面加载时是否获得焦点。
	 * （不适用于 type="hidden"）
	 **/
	public String getAutofocus() {
		return this.autofocus;
	}
	
	/**
	 * 规定输入字段在页面加载时是否获得焦点。
	 * （不适用于 type="hidden"）
	 **/
	public void setAutofocus(String autofocus) {
		this.autofocus = autofocus;
	}
	
	/** 引用包含输入字段的预定义选项的 datalist 。 **/
	public String getList() {
		return this.list;
	}
	
	/** 引用包含输入字段的预定义选项的 datalist 。 **/
	public void setList(String list) {
		this.list = list;
	}
	
	/**
	 * 覆盖表单的 method 属性。
	 * （适用于 type="submit" 和 type="image"）
	 **/
	public String getFormmethod() {
		return this.formmethod;
	}
	
	/**
	 * 覆盖表单的 method 属性。
	 * （适用于 type="submit" 和 type="image"）
	 **/
	public void setFormmethod(String formmethod) {
		this.formmethod = formmethod;
	}
	
	/**
	 * 覆盖表单的 action 属性。
	 * （适用于 type="submit" 和 type="image"）
	 **/
	public String getFormaction() {
		return this.formaction;
	}
	
	/**
	 * 覆盖表单的 action 属性。
	 * （适用于 type="submit" 和 type="image"）
	 **/
	public void setFormaction(String formaction) {
		this.formaction = formaction;
	}
	
	/**
	 * 覆盖表单的 target 属性。
	 * （适用于 type="submit" 和 type="image"）
	 **/
	public String getFormtarget() {
		return this.formtarget;
	}
	
	/**
	 * 覆盖表单的 target 属性。
	 * （适用于 type="submit" 和 type="image"）
	 **/
	public void setFormtarget(String formtarget) {
		this.formtarget = formtarget;
	}
	
	/** 规定元素的上下文菜单。上下文菜单在用户点击元素时显示。 **/
	public String getContextmenu() {
		return this.contextmenu;
	}
	
	/** 规定元素的上下文菜单。上下文菜单在用户点击元素时显示。 **/
	public void setContextmenu(String contextmenu) {
		this.contextmenu = contextmenu;
	}
	
	/** 规定此 input 元素首次加载时应当被选中。 **/
	public String getChecked() {
		return this.checked;
	}
	
	/** 规定此 input 元素首次加载时应当被选中。 **/
	public void setChecked(String checked) {
		this.checked = checked;
	}
	
	/** 规定是否对元素进行拼写和语法检查。 **/
	public String getSpellcheck() {
		return this.spellcheck;
	}
	
	/** 规定是否对元素进行拼写和语法检查。 **/
	public void setSpellcheck(String spellcheck) {
		this.spellcheck = spellcheck;
	}
	
	/** 规定元素是否可拖动。 **/
	public String getDraggable() {
		return this.draggable;
	}
	
	/** 规定元素是否可拖动。 **/
	public void setDraggable(String draggable) {
		this.draggable = draggable;
	}
	
	/** 规定通过文件上传来提交的文件的类型。 **/
	public String getAccept() {
		return this.accept;
	}
	
	/** 规定通过文件上传来提交的文件的类型。 **/
	public void setAccept(String accept) {
		this.accept = accept;
	}
	
	/** 规定元素的 tab 键次序。 **/
	public String getTabindex() {
		return this.tabindex;
	}
	
	/** 规定元素的 tab 键次序。 **/
	public void setTabindex(String tabindex) {
		this.tabindex = tabindex;
	}
	
	/** 规定输入字的的合法数字间隔。 **/
	public String getStep() {
		return this.step;
	}
	
	/** 规定输入字的的合法数字间隔。 **/
	public void setStep(String step) {
		this.step = step;
	}
	
	/** 自定义属性 **/
	public Map<String , String> getCustomAttr() {
		return customAttr;
	}
	
	/** 自定义属性 **/
	public void setCustomAttr(Map<String , String> customAttr) {
		this.customAttr = customAttr;
	}
	
}
