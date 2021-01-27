/**
 * P6Spy
 * <p>
 * Copyright (C) 2002 P6Spy
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.p6spy.engine.event;

import com.p6spy.engine.common.CallableStatementInformation;
import com.p6spy.engine.common.PreparedStatementInformation;
import com.p6spy.engine.common.ResultSetInformation;
import com.p6spy.engine.common.StatementInformation;

import java.sql.SQLException;

/**
 * This implementation of {@link JdbcEventListener} must always be applied as the first listener.
 * It populates the information objects {@link StatementInformation}, {@link PreparedStatementInformation},
 * {@link com.p6spy.engine.common.CallableStatementInformation} and {@link ResultSetInformation}
 */
public class DefaultEventListener extends JdbcEventListener {

  public static final DefaultEventListener INSTANCE = new DefaultEventListener();

  private DefaultEventListener() {
  }

  @Override
  public void onAfterAddBatch(StatementInformation s, long timeElapsedNanos, String sql, SQLException e) {
  }

  @Override
  public void onAfterExecute(PreparedStatementInformation s, long timeElapsedNanos, SQLException e) {
    s.incrementTimeElapsed(timeElapsedNanos);
  }

  @Override
  public void onAfterExecute(StatementInformation s, long timeElapsedNanos, String sql, SQLException e) {
    s.incrementTimeElapsed(timeElapsedNanos);
  }

  @Override
  public void onAfterExecuteBatch(StatementInformation s, long timeElapsedNanos, int[] updateCounts, SQLException e) {
    s.incrementTimeElapsed(timeElapsedNanos);
  }

  @Override
  public void onAfterExecuteUpdate(PreparedStatementInformation s, long timeElapsedNanos, int rowCount, SQLException e) {
    s.incrementTimeElapsed(timeElapsedNanos);
  }

  @Override
  public void onAfterExecuteUpdate(StatementInformation s, long timeElapsedNanos, String sql, int rowCount, SQLException e) {
    s.incrementTimeElapsed(timeElapsedNanos);
  }

  @Override
  public void onAfterExecuteQuery(PreparedStatementInformation s, long timeElapsedNanos, SQLException e) {
    s.incrementTimeElapsed(timeElapsedNanos);
  }

  @Override
  public void onAfterExecuteQuery(StatementInformation s, long timeElapsedNanos, String sql, SQLException e) {
    s.incrementTimeElapsed(timeElapsedNanos);
  }

  @Override
  public void onAfterGetResultSet(StatementInformation s, long timeElapsedNanos, SQLException e) {
    s.incrementTimeElapsed(timeElapsedNanos);
  }

  @Override
  public void onAfterResultSetNext(ResultSetInformation r, long timeElapsedNanos, boolean hasNext, SQLException e) {
    r.getStatementInformation().incrementTimeElapsed(timeElapsedNanos);
    if (hasNext) {
      r.incrementCurrRow();
    }
  }

  @Override
  public void onAfterCallableStatementSet(CallableStatementInformation c, String parameterName, Object value, SQLException e) {
    c.setParameterValue(parameterName, value);
  }

  @Override
  public void onAfterPreparedStatementSet(PreparedStatementInformation p, int parameterIndex, Object value, SQLException e) {
    p.setParameterValue(parameterIndex, value);
  }

}
