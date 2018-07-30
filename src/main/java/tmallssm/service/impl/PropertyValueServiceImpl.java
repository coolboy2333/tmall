package tmallssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.invoke.empty.Empty;
import tmallssm.mapper.PropertyValueMapper;
import tmallssm.pojo.Product;
import tmallssm.pojo.Property;
import tmallssm.pojo.PropertyValue;
import tmallssm.pojo.PropertyValueExample;
import tmallssm.service.PropertyService;
import tmallssm.service.PropertyValueService;

import java.util.List;

@Service
public class PropertyValueServiceImpl implements PropertyValueService{
    @Autowired
    PropertyValueMapper propertyValueMapper;
    @Autowired
    PropertyService propertyService;

    @Override
    public PropertyValue get(int ptid, int pid) {
        PropertyValueExample example=new PropertyValueExample();
        example.createCriteria().andPtidEqualTo(ptid).andPidEqualTo(pid);
        List<PropertyValue> pvs=propertyValueMapper.selectByExample(example);
        if (pvs.isEmpty())
            return null;
        return pvs.get(0);
    }
    @Override
    public void init(Product p) {
        //首先根据产品获取分类，然后获取这个分类下的所有属性集合
        List<Property> pts=propertyService.list(p.getCid());
        for (Property pt:pts){
            //用属性id和产品id去查询，看看这个属性和这个产品，是否已经存在属性值了。
            PropertyValue pv=get(pt.getId(),p.getId());
            // 如果不存在，那么就创建一个属性值，并设置其属性和产品，接着插入到数据库中。
            if (null==pv){
                pv=new PropertyValue();
                pv.setPid(p.getId());
                pv.setPtid(pt.getId());
                propertyValueMapper.insert(pv);
            }
        }
    }

    @Override
    public List<PropertyValue> list(int pid) {
        PropertyValueExample example=new PropertyValueExample();
        example.createCriteria().andPidEqualTo(pid);
        List<PropertyValue> pvs=propertyValueMapper.selectByExample(example);
        for (PropertyValue pv:pvs){
            Property property=propertyService.get(pv.getPtid());
            pv.setProperty(property);
        }
        return pvs;
    }

    @Override
    public void update(PropertyValue pv) {
        propertyValueMapper.updateByPrimaryKeySelective(pv);
    }
}
