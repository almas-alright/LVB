package com.alright.plastic.dailyex;

/**
 * Created by plastic on 9/3/2015.
 */
public class Item {
    //private variables
    int _id;
    String _item_name;
    String _item_val;

    public Item() {
    }

    public Item(String _item_name, String _item_val) {
        this._item_name = _item_name;
        this._item_val = _item_val;
    }

    public Item(int _id, String _item_name, String _item_val) {
        this._id = _id;
        this._item_name = _item_name;
        this._item_val = _item_val;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_item_name() {
        return _item_name;
    }

    public void set_item_name(String _item_name) {
        this._item_name = _item_name;
    }

    public String get_item_val() {
        return _item_val;
    }

    public void set_item_val(String _item_val) {
        this._item_val = _item_val;
    }
}
