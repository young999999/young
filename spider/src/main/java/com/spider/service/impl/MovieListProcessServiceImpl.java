package com.spider.service.impl;

import com.spider.entity.Page;
import com.spider.service.IProcessService;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;

/**
 * @author young
 * @create 2020-01-18 18:42
 */
public class MovieListProcessServiceImpl implements IProcessService {
    @Override
    public void process(Page page) {
        String content = page.getContent();

        HtmlCleaner htmlCleaner = new HtmlCleaner();
        TagNode rootNoade = htmlCleaner.clean(content);
        try {
            Object[] evaluateXPath = rootNoade.evaluateXPath("/body/div[5]");

            if (evaluateXPath.length > 0 && evaluateXPath != null) {
                TagNode node = (TagNode) evaluateXPath[0];

                /*node.getChildTagList() => ul的集合*/
                for (int i = 1; i < node.getChildTagList().size() - 2; i++) {

                    System.out.println();

                    /*node.getChildTagList().get(i) => ul*/
                    TagNode tagNode = node.getChildTagList().get(i);
                    System.err.println(tagNode.getName() + ": " + tagNode.getChildTagList().size());

                    /*tagNode.getChildTagList() => li的集合*/
                    for (TagNode tagNode1 : tagNode.getChildTagList()) {


                        System.out.println(tagNode1.getName() + ": " + tagNode1.getChildTagList().size());

                        for (int j = 1; j < tagNode1.getChildTagList().size(); j++) {
                            System.err.println(j + ": " + tagNode1.getChildTagList().get(j) + "-" + tagNode1.getChildTagList().get(j).getText());
                        }
                    }


                }


            }

        } catch (XPatherException e) {
            e.printStackTrace();
        }


    }
}
