package com.jdoilfield.operationalsystem.business;

import com.jdoilfield.operationalsystem.business.ManagerInterface;
import com.jdoilfield.operationalsystem.domain.GenericReport;
import com.pranical.commons.exceptions.LogicException;
import java.util.Map;

public abstract interface ReportManagerInterface<E> extends ManagerInterface<E>
{
  public static final Integer MAX_ROW_PER_PAGE = Integer.valueOf(65000);

  public abstract Map<String, Object> getReport(E paramE, String paramString)
    throws LogicException;

  public abstract GenericReport getExportReport(E paramE, String paramString)
    throws LogicException;
}