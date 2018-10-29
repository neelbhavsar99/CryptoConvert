package com.cryptoTRX.gabriel.cryptoconvert;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class FetchData extends AsyncTask<Void,Void,Void>
{
    String data;
    String savedline;
    double rateValue ;

    String resultStr ;
    TextView resultText;
    Random r = new Random();
    public String strURL;
    public int whichURL;
    //URL url;
    @Override

    protected Void doInBackground(Void... voids)
    {
        try
        {
            URL url = new URL("https://min-api.cryptocompare.com/data/price?fsym=CAD&tsyms=BTC,ETH&extraParams=your_app_name");

            if (whichURL == 1)
                url = new URL("https://min-api.cryptocompare.com/data/price?fsym=CAD&tsyms=BTC,ETH&extraParams=your_app_name");
            if (whichURL == 2)
                url = new URL("https://min-api.cryptocompare.com/data/price?fsym=USD&tsyms=BTC,ETH&extraParams=your_app_name");
            if (whichURL == 3)
                url = new URL("https://min-api.cryptocompare.com/data/price?fsym=EUR&tsyms=BTC,ETH&extraParams=your_app_name");

            if (whichURL == 4)
                url = new URL("https://min-api.cryptocompare.com/data/price?fsym=CAD&tsyms=ETH,ETH&extraParams=your_app_name");
            if (whichURL == 5)
                url = new URL("https://min-api.cryptocompare.com/data/price?fsym=USD&tsyms=ETH,ETH&extraParams=your_app_name");
            if (whichURL == 6)
                url = new URL("https://min-api.cryptocompare.com/data/price?fsym=EUR&tsyms=ETH,ETH&extraParams=your_app_name");

            if (whichURL == 7)
                url = new URL("https://min-api.cryptocompare.com/data/price?fsym=CAD&tsyms=LTC,ETH&extraParams=your_app_name");
            if (whichURL == 8)
                url = new URL("https://min-api.cryptocompare.com/data/price?fsym=USD&tsyms=LTC,ETH&extraParams=your_app_name");
            if (whichURL == 9)
                url = new URL("https://min-api.cryptocompare.com/data/price?fsym=EUR&tsyms=LTC,ETH&extraParams=your_app_name");

            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            data = "";
            if(inputStream != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                if(bufferedReader != null)
                {
                    String line = "";
                    while (line != null) {
                        line = bufferedReader.readLine();
                        data = data + line;
                    }
                    bufferedReader.close();
                }
                inputStream.close();
            }
            String strVal = MainActivity.currencyValue.getText().toString();

            if(data != "") {
                String [] splitRes = data.split(",");
                String [] getVal = splitRes[0].split(":");
                //savedline = data.substring(11, 20);
                rateValue = Double.parseDouble(getVal[1]); //rate from web
                //if(MainActivity.data.getText().toString() != getVal[1].toString())
                //    MainActivity.data.setText(getVal[1].toString());

                try {
                    double valMainActivity = Double.valueOf(strVal);

                    //int i1 = r.nextInt(100);
                    //rateValue *= i1;
                    double calcValue = valMainActivity * rateValue;
                    resultStr = String.format("%.10f", calcValue);
                }
                catch (Exception e)
                {
                    int x = 0;
                }
            }
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public void btnClickCall()
    {
        int len = MainActivity.factsarray.length;
        Random r = new Random();
        int pos = r.nextInt(len-1);
        MainActivity.factstr.setText(MainActivity.factsarray[pos]);
        MainActivity.convertedValueToUse.setText(this.resultStr);
    }
    @Override
    protected void onPostExecute(Void aVoid)
    {
        super.onPostExecute(aVoid);

        MainActivity.data.setText( String.format("%.10f", this.rateValue));
    }

}
