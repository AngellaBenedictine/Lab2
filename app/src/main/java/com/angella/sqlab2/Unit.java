package com.angella.sqlab2;

/**
 * Created by HP on 10/20/2017.
 */

public class Unit {
        int _id;
        String _name;
        String _info;

        public Unit() {
        }
        public Unit(int id,String name,String _info){
            this._id= id;
            this._name= name;
            this._info=_info;
        }
        public Unit(String name,String _info){
            this._name=name;
            this._info=_info;
        }
        public int getID(){
            return this._id;
        }
        public void setID(int id){
            this._id= id;
        }
        public String getName() {
            return this._name;
        }
        public void setName(String name){
            this._name= name;
        }
        public String get_info(){
            return this._info;
        }
        public void set_info(String _status){this._info=_info;}
    }


