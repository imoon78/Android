package com.imoon.app.imoonapp.clac;

/**
 * Created by 1027 on 2016-11-05.
 */

public class CalcServiceImp implements CalcService {
    @Override
    public int plus(CalcDTO dto) {
        return dto.getFirst() + dto.getSecond();
    }

    @Override
    public int nimus(CalcDTO dto) {
        return dto.getFirst() - dto.getSecond();
    }

    @Override
    public int muti(CalcDTO dto) {
        return dto.getFirst() * dto.getSecond();
    }

    @Override
    public int divid(CalcDTO dto) {
        return dto.getFirst() / dto.getSecond();
    }

    @Override
    public int mod(CalcDTO dto) {
        return dto.getFirst() % dto.getSecond();
    }
}
