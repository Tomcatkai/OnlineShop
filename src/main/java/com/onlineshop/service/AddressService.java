package com.onlineshop.service;

import com.onlineshop.dao.AddressDao;
import com.onlineshop.entity.Address;
import com.onlineshop.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 地址业务层
 *
 * @author kaizhang
 * @create 2018-05-07 0:12
 **/
@Service
public class AddressService {
    @Autowired
    AddressDao addressDao;

    /**
     * 通过用户id查询其的收货地址
     *
     * @param userId 用户id
     * @return 该用户的收货地址list集合
     */
    public List<Address> queryAddressByUid(String userId) {
        return addressDao.selectByUid(userId);
    }

    /**
     * 新建收货地址
     * @param addressUid 地址所属用户id
     * @param addressReceiver 收货人
     * @param addressReceiverPhone 收货人电话
     * @param addressDetail 收货详细地址
     * @param addressProvince 收货地省份
     * @param addressCity 收货地所属市
     * @param addressArea 收货地所属区
     * @param flag 是否设为默认地址
     * @return 操作记录数
     */
    public String createNewAddress(String addressUid, String addressReceiver, String addressReceiverPhone,
                                String addressDetail, String addressProvince, String addressCity,
                                String addressArea,boolean flag) {
        String addressId = CommonUtils.uuid();
        Address address = new Address();
        address.setAddressId(addressId);
        address.setAddressReceiver(addressReceiver);
        address.setAddressReceiverPhone(addressReceiverPhone);
        address.setAddressDetail(addressDetail);
        address.setAddressUid(addressUid);
        address.setAddressProvince(addressProvince);
        address.setAddressCity(addressCity);
        address.setAddressArea(addressArea);
        address.setAddressStatus(0);
        addressDao.insert(address);
        if(flag){
           updateAddressStatusToDefault(addressUid,addressId);
        }
        return addressId;
    }


    /**
     * 将指定的收货地址设置为默认收货地址
     *
     * @return
     */
    public int updateAddressStatusToDefault(String userId, String addressId) {
       /*
       1.将所有该用户所拥有的收货地址全置为非默认
       2.将指定的收货地址置为默认
        */
        List<Address> addressList = addressDao.selectByUid(userId);
        for (Address address : addressList) {
            address.setAddressStatus(0);
            addressDao.updateByPrimaryKey(address);
        }
        Address addressSelected = addressDao.selectByPrimaryKey(addressId);
        addressSelected.setAddressStatus(1);
        return addressDao.updateByPrimaryKey(addressSelected);
    }

    /**
     * 删除指定id的收货地址
     *
     * @param addressId
     * @return
     */
    public int deleteAddress(String addressId) {
        return addressDao.deleteByPrimaryKey(addressId);
    }
}
