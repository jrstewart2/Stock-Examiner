package uk.co.aegisphere.mccomparison.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "stock")
public class Stock {
  @Id
  private Long id;
  private String Symbol;
  private String AssetType;
  private String Name;
  private String Description;
  private long CIK;
  private String Exchange;
  private String Currency;
  private String Country;
  private String Sector;
  private String Industry;
  private String Address;
  private String FiscalYearEnd;
  private LocalDate LatestQuarter;
  private long MarketCapitalization;
  private long EBITDA;
  private double PEGRatio;
  private double BookValue;

}
