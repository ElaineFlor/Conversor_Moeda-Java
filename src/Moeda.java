public class Moeda {

    private final String moedaInicial;
    private final String moedaFinal;
    private final double valorConverter;
    private final double valorConvertido;


    public Moeda(String currencyBaseCode, String convertedCurrencyCode,
                 double amountToConvert, double convertedAmount) {

        this.moedaInicial = currencyBaseCode;
        this.moedaFinal = convertedCurrencyCode;
        this.valorConverter = amountToConvert;
        this.valorConvertido = convertedAmount;
    }

    @Override
    public String toString() {
        return String.format( """
                **************************************
                CONVERSÃO EXECUTADA COM SUCESSO
                
                Solicitação:  %s para %s
                                
                $%.2f %s corresponde a: $%.2f %s 
                ****************************************           
                """, this.moedaInicial, this.moedaFinal,
                this.valorConverter, this.moedaInicial,
                this.valorConvertido, this.moedaFinal);
    }
}
