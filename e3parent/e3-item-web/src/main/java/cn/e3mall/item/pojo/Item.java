package cn.e3mall.item.pojo;

import cn.e3mall.pojo.TbItem;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Eason
 * @date Create in 14:33 28/04/2018
 */
public class Item extends TbItem {

    public Item(TbItem tbItem) {
        this.setId(tbItem.getId());
        this.setTitle(tbItem.getTitle());
        this.setSellPoint(tbItem.getSellPoint());
        this.setPrice(tbItem.getPrice());
        this.setNum(tbItem.getNum());
        this.setBarcode(tbItem.getBarcode());
        this.setImage(tbItem.getImage());
        this.setCid(tbItem.getCid());
        this.setStatus(tbItem.getStatus());
        this.setCreated(tbItem.getCreated());
        this.setUpdated(tbItem.getUpdated());
    }

    public String[] getImages() {
        String image = getImage();
        if (StringUtils.isNotBlank(image)) {
            return image.split(",");
        }
        return null;
    }

}
