package com.lianyun.scan.gree.ad.controller;

import com.lianyun.scan.frame.model.IdAble;
import com.lianyun.scan.frame.model.PageCondition;
import com.lianyun.scan.gree.controller.CurdController;

public abstract class AbstractGreeAdController<K, V extends IdAble<K>, P extends PageCondition>
		extends CurdController<K, V, P> {

}
