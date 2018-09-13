package com.lianyun.scan.gree.controller;

import com.lianyun.scan.frame.BaseController;
import com.lianyun.scan.frame.model.IdAble;
import com.lianyun.scan.frame.model.PageCondition;

public abstract class CurdController<K, V extends IdAble<K>, P extends PageCondition> extends BaseController<K, V, P> {


}
