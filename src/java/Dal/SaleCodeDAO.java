package Dal;

import Model.SaleCode;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author DucPhaoLo
 */
public class SaleCodeDAO extends ConnectMySQL {

    public float checkValidSaleCodeAndReturnSaleRate(String saleCode) {
        try {
            String sqlSelect = "SELECT * FROM swp.salecode where code =? and expiration_date >= ?;";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setString(1, saleCode);
            SimpleDateFormat sfDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            pstm.setDate(2, java.sql.Date.valueOf(sfDateFormat.format(date)));
            rs = pstm.executeQuery();
            while (rs.next()) {
                if (rs.getInt(3) > 0) {
                    return rs.getFloat(5);
                }
            }
        } catch (Exception e) {
            System.out.println("checkValidSalceCode: " + e);
        }
        return 0;
    }

    public SaleCode getSaleCodeByName(String saleCode) {
        try {
            String sqlSelect = "SELECT * FROM swp.salecode where code =?;";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setString(1, saleCode);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String salecodeID = String.valueOf(rs.getInt(1));
                String code = String.valueOf(rs.getString(2));
                String amount = String.valueOf(rs.getInt(3));
                String expiration_date = String.valueOf(rs.getDate(4));
                String salecodeRate = String.valueOf(rs.getFloat(5));
                return  new SaleCode(salecodeID, code, amount, expiration_date, salecodeRate);
            }
        } catch (Exception e) {
            System.out.println("getSaleCodeAmount: " + e);
        }
        return null;
    }

    public boolean decreaseSaleCodeAmount(String saleCodeID, String amount) {
        try {
            String sqlSelect = "update swp.salecode set amount=? where `salecodeid` =?;";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, Integer.parseInt(amount)-1);
            pstm.setInt(2, Integer.parseInt(saleCodeID));
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("decreaseSaleCodeAmount: " + e);
        }
        return false;
    }

    public static void main(String[] args) {
        SaleCodeDAO saleCodeDAO = new SaleCodeDAO();
//        System.out.println(saleCodeDAO.checkValidSaleCodeAndReturnSaleRate("12bjbqbwe"));
//        System.out.println(saleCodeDAO.getSaleCodeAmount("jjijfidsj"));
        SaleCode saleCode = saleCodeDAO.getSaleCodeByName("jjijfidsj");
        System.out.println(saleCode.getExpiration_date());
        System.out.println(saleCodeDAO.decreaseSaleCodeAmount(saleCode.getSalecodeID(), saleCode.getAmount()));
    }
}
