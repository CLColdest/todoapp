package com.coldie.todoapp.mapper;

public interface IMapper <I,O>{ //nos permite mapear de modo que convirtamos un objeto en otro
    public O map(I in);
}
