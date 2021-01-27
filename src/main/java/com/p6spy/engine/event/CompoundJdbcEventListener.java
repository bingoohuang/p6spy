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

import com.p6spy.engine.common.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompoundJdbcEventListener extends JdbcEventListener {
  private final List<JdbcEventListener> eventListeners;

  public CompoundJdbcEventListener() {
    eventListeners = new ArrayList<JdbcEventListener>();
  }

  public CompoundJdbcEventListener(List<JdbcEventListener> eventListeners) {
    this.eventListeners = eventListeners;
  }


  /**
   * Adds a listener to this {@link CompoundJdbcEventListener}
   *
   * @param listener The listener to add
   * @deprecated This method name has a typo, please use {@link CompoundJdbcEventListener#addListener}
   */
  public void addListender(JdbcEventListener listener) {
    addListener(listener);
  }

  /**
   * Adds a listener to this {@link CompoundJdbcEventListener}
   *
   * @param listener The listener to add
   */
  public void addListener(JdbcEventListener listener) {
    eventListeners.add(listener);
  }

  /**
   * Returns a read only view of the registered {@link JdbcEventListener}s
   *
   * @return a read only view of the registered {@link JdbcEventListener}s
   */
  public List<JdbcEventListener> getEventListeners() {
    return Collections.unmodifiableList(eventListeners);
  }

  @Override
  public void onBeforeGetConnection(ConnectionInformation c) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onBeforeGetConnection(c);
    }
  }

  @Override
  public void onAfterGetConnection(ConnectionInformation c, SQLException e) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onAfterGetConnection(c, e);
    }
  }

  @Override
  @Deprecated
  public void onConnectionWrapped(ConnectionInformation c) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onConnectionWrapped(c);
    }
  }

  @Override
  public void onBeforeAddBatch(PreparedStatementInformation p) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onBeforeAddBatch(p);
    }
  }

  @Override
  public void onAfterAddBatch(PreparedStatementInformation p, long timeElapsedNanos, SQLException e) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onAfterAddBatch(p, timeElapsedNanos, e);
    }
  }

  @Override
  public void onBeforeAddBatch(StatementInformation s, String sql) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onBeforeAddBatch(s, sql);
    }
  }

  @Override
  public void onAfterAddBatch(StatementInformation s, long timeElapsedNanos, String sql, SQLException e) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onAfterAddBatch(s, timeElapsedNanos, sql, e);
    }
  }

  @Override
  public void onBeforeExecute(PreparedStatementInformation p) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onBeforeExecute(p);
    }
  }

  @Override
  public void onAfterExecute(PreparedStatementInformation p, long timeElapsedNanos, SQLException e) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onAfterExecute(p, timeElapsedNanos, e);
    }
  }

  @Override
  public void onBeforeExecute(StatementInformation s, String sql) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onBeforeExecute(s, sql);
    }
  }

  @Override
  public void onAfterExecute(StatementInformation s, long timeElapsedNanos, String sql, SQLException e) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onAfterExecute(s, timeElapsedNanos, sql, e);
    }
  }

  @Override
  public void onBeforeExecuteBatch(StatementInformation s) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onBeforeExecuteBatch(s);
    }
  }

  @Override
  public void onAfterExecuteBatch(StatementInformation s, long timeElapsedNanos, int[] updateCounts, SQLException e) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onAfterExecuteBatch(s, timeElapsedNanos, updateCounts, e);
    }
  }

  @Override
  public void onBeforeExecuteUpdate(PreparedStatementInformation p) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onBeforeExecuteUpdate(p);
    }
  }

  @Override
  public void onAfterExecuteUpdate(PreparedStatementInformation s, long timeElapsedNanos, int rowCount, SQLException e) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onAfterExecuteUpdate(s, timeElapsedNanos, rowCount, e);
    }
  }

  @Override
  public void onBeforeExecuteUpdate(StatementInformation s, String sql) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onBeforeExecuteUpdate(s, sql);
    }
  }

  @Override
  public void onAfterExecuteUpdate(StatementInformation s, long timeElapsedNanos, String sql, int rowCount, SQLException e) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onAfterExecuteUpdate(s, timeElapsedNanos, sql, rowCount, e);
    }
  }

  @Override
  public void onBeforeExecuteQuery(PreparedStatementInformation p) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onBeforeExecuteQuery(p);
    }
  }

  @Override
  public void onAfterExecuteQuery(PreparedStatementInformation p, long timeElapsedNanos, SQLException e) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onAfterExecuteQuery(p, timeElapsedNanos, e);
    }
  }

  @Override
  public void onBeforeExecuteQuery(StatementInformation s, String sql) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onBeforeExecuteQuery(s, sql);
    }
  }

  @Override
  public void onAfterExecuteQuery(StatementInformation s, long timeElapsedNanos, String sql, SQLException e) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onAfterExecuteQuery(s, timeElapsedNanos, sql, e);
    }
  }

  @Override
  public void onAfterPreparedStatementSet(PreparedStatementInformation p, int parameterIndex, Object value, SQLException e) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onAfterPreparedStatementSet(p, parameterIndex, value, e);
    }
  }

  @Override
  public void onAfterCallableStatementSet(CallableStatementInformation c, String parameterName, Object value, SQLException e) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onAfterCallableStatementSet(c, parameterName, value, e);
    }
  }

  @Override
  public void onAfterGetResultSet(StatementInformation s, long timeElapsedNanos, SQLException e) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onAfterGetResultSet(s, timeElapsedNanos, e);
    }
  }

  @Override
  public void onBeforeResultSetNext(ResultSetInformation r) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onBeforeResultSetNext(r);
    }
  }

  @Override
  public void onAfterResultSetNext(ResultSetInformation r, long timeElapsedNanos, boolean hasNext, SQLException e) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onAfterResultSetNext(r, timeElapsedNanos, hasNext, e);
    }
  }

  @Override
  public void onAfterResultSetClose(ResultSetInformation r, SQLException e) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onAfterResultSetClose(r, e);
    }
  }

  @Override
  public void onAfterResultSetGet(ResultSetInformation r, String columnLabel, Object value, SQLException e) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onAfterResultSetGet(r, columnLabel, value, e);
    }
  }

  @Override
  public void onAfterResultSetGet(ResultSetInformation r, int columnIndex, Object value, SQLException e) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onAfterResultSetGet(r, columnIndex, value, e);
    }
  }

  @Override
  public void onBeforeCommit(ConnectionInformation c) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onBeforeCommit(c);
    }
  }

  @Override
  public void onAfterCommit(ConnectionInformation c, long timeElapsedNanos, SQLException e) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onAfterCommit(c, timeElapsedNanos, e);
    }
  }

  @Override
  public void onAfterConnectionClose(ConnectionInformation c, SQLException e) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onAfterConnectionClose(c, e);
    }
  }

  @Override
  public void onBeforeRollback(ConnectionInformation c) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onBeforeRollback(c);
    }
  }

  @Override
  public void onAfterRollback(ConnectionInformation c, long timeElapsedNanos, SQLException e) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onAfterRollback(c, timeElapsedNanos, e);
    }
  }

  @Override
  public void onAfterStatementClose(StatementInformation s, SQLException e) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onAfterStatementClose(s, e);
    }
  }

  @Override
  public void onBeforeSetAutoCommit(ConnectionInformation c, boolean newAutoCommit, boolean currentAutoCommit) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onBeforeSetAutoCommit(c, newAutoCommit, currentAutoCommit);
    }
  }

  @Override
  public void onAfterSetAutoCommit(ConnectionInformation c, boolean newAutoCommit, boolean oldAutoCommit, SQLException e) {
    for (JdbcEventListener eventListener : eventListeners) {
      eventListener.onAfterSetAutoCommit(c, newAutoCommit, oldAutoCommit, e);
    }
  }

}
