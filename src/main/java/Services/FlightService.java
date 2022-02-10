package Services;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.airlinereservationsystemapp.DaoImpl.SourceDao;
import com.airlinereservationsystemapp.DaoImpl.WalletDao;
import com.airlinereservationsystemapp.Models.FlightList;
import com.airlinereservationsystemapp.Models.Source;

public class FlightService {
	
		public List<Source> getsource() throws ClassNotFoundException, SQLException
		{
		
		List<Source> sourcefilght = new ArrayList<>();
		
		SourceDao objsource  = new SourceDao ();
		 sourcefilght = objsource.ListSource();
		
		return sourcefilght;
		
		
	}
		
		public int getclosingbalance(String username) throws Exception
		{
		
		int Closing_balance = 0;
		WalletDao objwallet  = new WalletDao ();
		Closing_balance  = objwallet.getclosingbalance(username);
		
		return Closing_balance;
		}
		
		
		

}
