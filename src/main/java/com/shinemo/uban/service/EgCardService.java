package com.shinemo.uban.service;

import com.shinemo.uban.config.EgConstant;
import com.shinemo.uban.param.CardParam.CardAddParam;
import com.shinemo.uban.param.CardParam.CardRuleDelParam;
import com.shinemo.uban.param.CardParam.CardRuleSetParam;
import com.shinemo.uban.param.Result;

/**
 * User: luchao
 * Mail: luc@shinemo.com
 * Date: 2017/4/13
 * Time: 11:41
 */
public class EgCardService extends BaseService {

    /**
     * 添加名片
     * @param cardAddParam
     * @return
     * @throws Exception
     */
    public Result add(CardAddParam cardAddParam) throws Exception {
        return invoke(cardAddParam, EgConstant.ADD_CARD_URI);
    }

    /**
     * 删除名片
     * @param cardAddParam
     * @return
     * @throws Exception
     */
    public Result del(CardAddParam cardAddParam) throws Exception {
        return invoke(cardAddParam, EgConstant.DEL_CARD_URI);
    }

    /**
     * 设置名片规则
     * @param cardRuleSetParam
     * @return
     * @throws Exception
     */
    public Result setRule(CardRuleSetParam cardRuleSetParam) throws Exception {
        return invoke(cardRuleSetParam, EgConstant.SET_CARD_RULE_URI);
    }

    /**
     * 删除名片规则
     * @param cardRuleDelParam
     * @return
     * @throws Exception
     */
    public Result delRule(CardRuleDelParam cardRuleDelParam) throws Exception {
        return invoke(cardRuleDelParam, EgConstant.DEL_CARD_RULE_URI);
    }
}
