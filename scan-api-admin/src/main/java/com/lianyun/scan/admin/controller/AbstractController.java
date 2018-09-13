package com.lianyun.scan.admin.controller;

import com.lianyun.scan.frame.BaseController;
import com.lianyun.scan.frame.model.IdAble;
import com.lianyun.scan.frame.model.PageCondition;


public abstract class AbstractController<K, V extends IdAble<K>> extends BaseController<K, V,PageCondition>{

}
