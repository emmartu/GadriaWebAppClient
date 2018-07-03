package it.mountaineering.gadria.client.mvc.model;

public abstract class DemoLanguage {

	//MENU PRINCIPALE
	public String resetDemoLabel = "Reimpostazione Dati";
	public String itViewsLabel = "Dati IT";
	public String bpViewsLabel = "Dati BP";
	
	//PAGINA SETUP
	public String globalSetUpLabel = "Impostazione Ambiente";
	public String globalSetUpSuccess = "Impostazione Riuscita!";
	public String globalLoadTestDataLabel = "Carica Dati Demo";
	public String globalLoadTestDataSuccess = "Dati caricati!";

	public String allLabel = "Tutte";
	public String sourceTypeLabel = "Provenienza";
	public String dateFromLabel = "Data Inizio";
	public String dateToLabel = "Data Fine";
	public String groupByLabel = "Raggrupati per";
	public String monthLabel = "Mese";
	public String weekLabel = "Settimana";
	public String yearLabel = "Anno";
	public String dayLabel = "Giorno";

	public String dataTypeLabel = "Tipologia Dati";

	public String numero_totale_invii_Label = "n. totale di invii";
	public String n_invii_per_provenienza_Label = "n. totale di invii per provenienza";
	public String numero_invii_monoprofessionali_Label = "n. di invii monoprofessionali";
	public String numero_invii_congiunti_Label = "n. di invii congiunti";
	public String numero_invii_in_UVM_prese_in_carico_dai_servizi_Label = "n. di invii UVM presi in carico dai servizi";						
	public String invii_valutati_non_appropriati_per_UVM_Label = "n. invii valutati non appropriati per UVM";
	public String n_attivazioni_UVM_tempo_maggiore_20_giorni_Label = "n. attivazioni UVM con tempo > 20 giorni";
	public String n_valutazioni_UVM_per_fragilita_Label = "n. persone valutate in UVM, distinti per area di fragilit�";
	public String n_valutazioni_UVM_per_fragilita_per_provenienza_Label = "n. persone valutate in UVM, distinti per area di fragilit� e per provenienza";
	public String n_valutazioni_UVM_per_fragilita_tot_Label = "totale n. persone valutate in UVM, distinti per area di fragilit�";
	public String n_valutazioni_UVM_con_indennita_Label = "n. persone valutate in UVM gi� in possesso di indennit�";
	public String n_giorni_tra_valutazione_UVM_e_PAI_Label = "n. giorni medi attesa tra valutazione UVM e attivazione PAI";
	public String n_erogazioni_info_orientamento_Label = "n. di attivazioni di erogazione servizi";
	public String n_erogazioni_presidi_ausili_Label = "n. di attivazioni di erogazione presidi ausili";
	public String n_valutazioni_per_tipo_inviante_Label = "totale n. persone distinte per tipo richiedente";
	public String showsChartLabel = "Mostra Istogramma";
	
	public String uploadSpecificTraceLabel = "Upload Specific Trace";
	public String uploadLabel = "";
	public String chooseTestSequenceLabel = "";
	public String standardXHealthServices = "";
	public String standardXSocialServices = "";
	public String standardXPresidium = "";
	public String standardXUVM = "";
	public String missingReceipt = "";
	public String doubleServiceActivation = "";
	public String socialServicesAndThenUVMActivation = "";
	public String uVMAndThenSocialServicesActivation = "";
	public String immediateClosing = "";
	public String selectLabel = "";	
	public String nextStep = "";
	public String performAllSteps = "";
	public String lastStep = "";

	
	public abstract String getGlobalSetUpLabel();

	public abstract void setGlobalSetUpLabel(String globalSetUpLabel);

	public abstract String getGlobalSetUpSuccess();

	public abstract void setGlobalSetUpSuccess(String globalSetUpSuccess);

	public abstract String getGlobalLoadTestDataLabel();

	public abstract void setGlobalLoadTestDataLabel(String globalLoadTestDataLabel);

	public abstract String getGlobalLoadTestDataSuccess();

	public abstract void setGlobalLoadTestDataSuccess(String globalLoadTestDataSuccess);

	public abstract String getResetDemoLabel();

	public abstract void setResetDemoLabel(String resetDemoLabel);

	public abstract String getItViewsLabel();

	public abstract void setItViewsLabel(String itViewsLabel);

	public abstract String getBpViewsLabel();

	public abstract void setBpViewsLabel(String bpViewsLabel);

	public abstract String getAllLabel();

	public abstract void setAllLabel(String allLabel);

	public abstract String getSourceTypeLabel();

	public abstract void setSourceTypeLabel(String sourceTypeLabel);

	public abstract String getDateFromLabel();

	public abstract void setDateFromLabel(String dateFromLabel);

	public abstract String getDateToLabel();

	public abstract void setDateToLabel(String dateToLabel);

	public abstract String getGroupByLabel();

	public abstract void setGroupByLabel(String groupByLabel);

	public abstract String getMonthLabel();

	public abstract void setMonthLabel(String monthLabel);

	public abstract String getWeekLabel();

	public abstract void setWeekLabel(String weekLabel);

	public abstract String getYearLabel();

	public abstract void setYearLabel(String yearLabel);

	public abstract String getDayLabel();

	public abstract void setDayLabel(String dayLabel);

	public abstract String getDataTypeLabel();

	public abstract void setDataTypeLabel(String dataTypeLabel);

	public abstract String getNumero_totale_invii_Label();

	public abstract void setNumero_totale_invii_Label(String numero_totale_invii_Label);

	public abstract String getN_invii_per_provenienza_Label();

	public abstract void setN_invii_per_provenienza_Label(String n_invii_per_provenienza_Label);

	public abstract String getNumero_invii_monoprofessionali_Label();

	public abstract void setNumero_invii_monoprofessionali_Label(String numero_invii_monoprofessionali_Label);

	public abstract String getNumero_invii_congiunti_Label();

	public abstract void setNumero_invii_congiunti_Label(String numero_invii_congiunti_Label);

	public abstract String getNumero_invii_in_UVM_prese_in_carico_dai_servizi_Label();

	public abstract void setNumero_invii_in_UVM_prese_in_carico_dai_servizi_Label(String numero_invii_in_UVM_prese_in_carico_dai_servizi_Label);

	public abstract String getInvii_valutati_non_appropriati_per_UVM_Label();

	public abstract void setInvii_valutati_non_appropriati_per_UVM_Label(String invii_valutati_non_appropriati_per_UVM_Label);

	public abstract String getN_attivazioni_UVM_tempo_maggiore_20_giorni_Label();

	public abstract void setN_attivazioni_UVM_tempo_maggiore_20_giorni_Label(String n_attivazioni_UVM_tempo_maggiore_20_giorni_Label);

	public abstract String getN_valutazioni_UVM_per_fragilita_Label();

	public abstract void setN_valutazioni_UVM_per_fragilita_Label(String n_valutazioni_UVM_per_fragilita_Label);

	public abstract String getN_valutazioni_UVM_per_fragilita_per_provenienza_Label();

	public abstract void setN_valutazioni_UVM_per_fragilita_per_provenienza_Label(String n_valutazioni_UVM_per_fragilita_per_provenienza_Label);

	public abstract String getN_valutazioni_UVM_per_fragilita_tot_Label();

	public abstract void setN_valutazioni_UVM_per_fragilita_tot_Label(String n_valutazioni_UVM_per_fragilita_tot_Label);

	public abstract String getN_valutazioni_UVM_con_indennita_Label();

	public abstract void setN_valutazioni_UVM_con_indennita_Label(String n_valutazioni_UVM_con_indennita_Label);

	public abstract String getN_giorni_tra_valutazione_UVM_e_PAI_Label();

	public abstract void setN_giorni_tra_valutazione_UVM_e_PAI_Label(String n_giorni_tra_valutazione_UVM_e_PAI_Label);

	public abstract String getN_erogazioni_info_orientamento_Label();

	public abstract void setN_erogazioni_info_orientamento_Label(String n_erogazioni_info_orientamento_Label);

	public abstract String getN_erogazioni_presidi_ausili_Label();

	public abstract void setN_erogazioni_presidi_ausili_Label(String n_erogazioni_presidi_ausili_Label);

	public abstract String getN_valutazioni_per_tipo_inviante_Label();

	public abstract void setN_valutazioni_per_tipo_inviante_Label(String n_valutazioni_per_tipo_inviante_Label);

}
