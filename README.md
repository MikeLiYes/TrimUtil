# TrimUtil
Trim all string attribute for Object in two level to prevent blank error.
去掉对象的字符串属性所有左右空格，防止字符串属性左右多空格导致出现bug。

主要思想： 通过spring的面向切面将指定方法的字符串参数自动去掉左右空格。

Simple but helpful.
简单但实用

maven : 
<dependency>
  <groupId>com.github.mikeliyes</groupId>
  <artifactId>TrimUtil</artifactId>
  <version>0.0.1</version>
</dependency>

注：
暂时不支持map对象
not support map

记录：
eclipse上传maven：run as -> run configuration -> maven build-> 右键new -> browse Workspace选择当前项目路径：${workspace_loc:/TrimUtil} ->goals输入clean install source:jar javadoc:jar gpg:sign deploy -e
