package Bank_System;

import java.util.Calendar;
import java.util.GregorianCalendar;

public enum KyHan {
    Một_Tuần {
        @Override
        public Calendar TinhNgayDaoHan(Calendar d) {
            d.add(Calendar.DAY_OF_YEAR, 7);

            return d;
        }

        @Override
        public double TinhLai(double tien) {
            // co 365/366 ngay = 0.02*tien
            Calendar ca = new GregorianCalendar();

            return (7 * 0.02 * tien / ca.getActualMaximum(Calendar.DAY_OF_YEAR));
        }
    },
    Một_Tháng {
        @Override
        public Calendar TinhNgayDaoHan(Calendar d) {
            d.add(Calendar.MONTH, 1);

            return d;
        }

        @Override
        public double TinhLai(double tien) {
            // 1 nam co 12 thang = 0.055*tien/12
            return (0.055 * tien) / 12;
        }
    },
    Sáu_Tháng {
        @Override
        public Calendar TinhNgayDaoHan(Calendar d) {
            d.add(Calendar.MONTH, 6);

            return d;
        }

        @Override
        public double TinhLai(double tien) {
            // 1 nam co 12 thang = 0.075*tien/ 2
            return (0.075 * tien) / 2;
        }
    },
    Mười_Hai_Tháng {
        @Override
        public Calendar TinhNgayDaoHan(Calendar d) {
            d.add(Calendar.YEAR, 1);
            return d;
        }

        @Override
        public double TinhLai(double tien) {
            return 0.079 * tien;
        }
    };

    public abstract Calendar TinhNgayDaoHan(Calendar d);

    public abstract double TinhLai(double tien);
}
