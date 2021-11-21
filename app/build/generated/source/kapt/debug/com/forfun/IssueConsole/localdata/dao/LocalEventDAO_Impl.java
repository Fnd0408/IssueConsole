package com.forfun.IssueConsole.localdata.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.forfun.IssueConsole.localdata.model.Event;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class LocalEventDAO_Impl implements LocalEventDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfEvent;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfEvent;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfEvent;

  public LocalEventDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEvent = new EntityInsertionAdapter<Event>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `LocalEvent`(`Event_ID`,`EVENT_CONTENT`,`EVENT_CREATEDATE`,`EVENT_CREATOR`,`EVENT_TITLE`,`EVENT_LEVEL`,`PROCESSING_PEOPLE_DEPT`,`PROCESSING_PEOPLE_ID`,`PROCESSING_PEOPLE_NAME`,`PROCESSING_TYPE`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Event value) {
        stmt.bindLong(1, value.getEvent_ID());
        if (value.getEVENT_CONTENT() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEVENT_CONTENT());
        }
        if (value.getEVENT_CREATEDATE() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEVENT_CREATEDATE());
        }
        if (value.getEVENT_CREATOR() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getEVENT_CREATOR());
        }
        if (value.getEVENT_TITLE() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getEVENT_TITLE());
        }
        stmt.bindLong(6, value.getEVENT_LEVEL());
        if (value.getPROCESSING_PEOPLE_DEPT() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPROCESSING_PEOPLE_DEPT());
        }
        if (value.getPROCESSING_PEOPLE_ID() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getPROCESSING_PEOPLE_ID());
        }
        if (value.getPROCESSING_PEOPLE_NAME() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getPROCESSING_PEOPLE_NAME());
        }
        stmt.bindLong(10, value.getPROCESSING_TYPE());
      }
    };
    this.__deletionAdapterOfEvent = new EntityDeletionOrUpdateAdapter<Event>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `LocalEvent` WHERE `Event_ID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Event value) {
        stmt.bindLong(1, value.getEvent_ID());
      }
    };
    this.__updateAdapterOfEvent = new EntityDeletionOrUpdateAdapter<Event>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `LocalEvent` SET `Event_ID` = ?,`EVENT_CONTENT` = ?,`EVENT_CREATEDATE` = ?,`EVENT_CREATOR` = ?,`EVENT_TITLE` = ?,`EVENT_LEVEL` = ?,`PROCESSING_PEOPLE_DEPT` = ?,`PROCESSING_PEOPLE_ID` = ?,`PROCESSING_PEOPLE_NAME` = ?,`PROCESSING_TYPE` = ? WHERE `Event_ID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Event value) {
        stmt.bindLong(1, value.getEvent_ID());
        if (value.getEVENT_CONTENT() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEVENT_CONTENT());
        }
        if (value.getEVENT_CREATEDATE() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEVENT_CREATEDATE());
        }
        if (value.getEVENT_CREATOR() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getEVENT_CREATOR());
        }
        if (value.getEVENT_TITLE() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getEVENT_TITLE());
        }
        stmt.bindLong(6, value.getEVENT_LEVEL());
        if (value.getPROCESSING_PEOPLE_DEPT() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPROCESSING_PEOPLE_DEPT());
        }
        if (value.getPROCESSING_PEOPLE_ID() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getPROCESSING_PEOPLE_ID());
        }
        if (value.getPROCESSING_PEOPLE_NAME() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getPROCESSING_PEOPLE_NAME());
        }
        stmt.bindLong(10, value.getPROCESSING_TYPE());
        stmt.bindLong(11, value.getEvent_ID());
      }
    };
  }

  @Override
  public void insert(Event... Events) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfEvent.insert(Events);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Event... Events) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfEvent.handleMultiple(Events);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(Event... Events) {
    __db.beginTransaction();
    try {
      __updateAdapterOfEvent.handleMultiple(Events);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Event> getAllEvents() {
    final String _sql = "SELECT * FROM LocalEvent WHERE PROCESSING_TYPE != 3";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfEventID = _cursor.getColumnIndexOrThrow("Event_ID");
      final int _cursorIndexOfEVENTCONTENT = _cursor.getColumnIndexOrThrow("EVENT_CONTENT");
      final int _cursorIndexOfEVENTCREATEDATE = _cursor.getColumnIndexOrThrow("EVENT_CREATEDATE");
      final int _cursorIndexOfEVENTCREATOR = _cursor.getColumnIndexOrThrow("EVENT_CREATOR");
      final int _cursorIndexOfEVENTTITLE = _cursor.getColumnIndexOrThrow("EVENT_TITLE");
      final int _cursorIndexOfEVENTLEVEL = _cursor.getColumnIndexOrThrow("EVENT_LEVEL");
      final int _cursorIndexOfPROCESSINGPEOPLEDEPT = _cursor.getColumnIndexOrThrow("PROCESSING_PEOPLE_DEPT");
      final int _cursorIndexOfPROCESSINGPEOPLEID = _cursor.getColumnIndexOrThrow("PROCESSING_PEOPLE_ID");
      final int _cursorIndexOfPROCESSINGPEOPLENAME = _cursor.getColumnIndexOrThrow("PROCESSING_PEOPLE_NAME");
      final int _cursorIndexOfPROCESSINGTYPE = _cursor.getColumnIndexOrThrow("PROCESSING_TYPE");
      final List<Event> _result = new ArrayList<Event>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Event _item;
        _item = new Event();
        final int _tmpEvent_ID;
        _tmpEvent_ID = _cursor.getInt(_cursorIndexOfEventID);
        _item.setEvent_ID(_tmpEvent_ID);
        final String _tmpEVENT_CONTENT;
        _tmpEVENT_CONTENT = _cursor.getString(_cursorIndexOfEVENTCONTENT);
        _item.setEVENT_CONTENT(_tmpEVENT_CONTENT);
        final String _tmpEVENT_CREATEDATE;
        _tmpEVENT_CREATEDATE = _cursor.getString(_cursorIndexOfEVENTCREATEDATE);
        _item.setEVENT_CREATEDATE(_tmpEVENT_CREATEDATE);
        final String _tmpEVENT_CREATOR;
        _tmpEVENT_CREATOR = _cursor.getString(_cursorIndexOfEVENTCREATOR);
        _item.setEVENT_CREATOR(_tmpEVENT_CREATOR);
        final String _tmpEVENT_TITLE;
        _tmpEVENT_TITLE = _cursor.getString(_cursorIndexOfEVENTTITLE);
        _item.setEVENT_TITLE(_tmpEVENT_TITLE);
        final int _tmpEVENT_LEVEL;
        _tmpEVENT_LEVEL = _cursor.getInt(_cursorIndexOfEVENTLEVEL);
        _item.setEVENT_LEVEL(_tmpEVENT_LEVEL);
        final String _tmpPROCESSING_PEOPLE_DEPT;
        _tmpPROCESSING_PEOPLE_DEPT = _cursor.getString(_cursorIndexOfPROCESSINGPEOPLEDEPT);
        _item.setPROCESSING_PEOPLE_DEPT(_tmpPROCESSING_PEOPLE_DEPT);
        final String _tmpPROCESSING_PEOPLE_ID;
        _tmpPROCESSING_PEOPLE_ID = _cursor.getString(_cursorIndexOfPROCESSINGPEOPLEID);
        _item.setPROCESSING_PEOPLE_ID(_tmpPROCESSING_PEOPLE_ID);
        final String _tmpPROCESSING_PEOPLE_NAME;
        _tmpPROCESSING_PEOPLE_NAME = _cursor.getString(_cursorIndexOfPROCESSINGPEOPLENAME);
        _item.setPROCESSING_PEOPLE_NAME(_tmpPROCESSING_PEOPLE_NAME);
        final byte _tmpPROCESSING_TYPE;
        _tmpPROCESSING_TYPE = (byte) _cursor.getShort(_cursorIndexOfPROCESSINGTYPE);
        _item.setPROCESSING_TYPE(_tmpPROCESSING_TYPE);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Event> getAllFinishedEvents() {
    final String _sql = "SELECT * FROM LocalEvent WHERE PROCESSING_TYPE == 3";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfEventID = _cursor.getColumnIndexOrThrow("Event_ID");
      final int _cursorIndexOfEVENTCONTENT = _cursor.getColumnIndexOrThrow("EVENT_CONTENT");
      final int _cursorIndexOfEVENTCREATEDATE = _cursor.getColumnIndexOrThrow("EVENT_CREATEDATE");
      final int _cursorIndexOfEVENTCREATOR = _cursor.getColumnIndexOrThrow("EVENT_CREATOR");
      final int _cursorIndexOfEVENTTITLE = _cursor.getColumnIndexOrThrow("EVENT_TITLE");
      final int _cursorIndexOfEVENTLEVEL = _cursor.getColumnIndexOrThrow("EVENT_LEVEL");
      final int _cursorIndexOfPROCESSINGPEOPLEDEPT = _cursor.getColumnIndexOrThrow("PROCESSING_PEOPLE_DEPT");
      final int _cursorIndexOfPROCESSINGPEOPLEID = _cursor.getColumnIndexOrThrow("PROCESSING_PEOPLE_ID");
      final int _cursorIndexOfPROCESSINGPEOPLENAME = _cursor.getColumnIndexOrThrow("PROCESSING_PEOPLE_NAME");
      final int _cursorIndexOfPROCESSINGTYPE = _cursor.getColumnIndexOrThrow("PROCESSING_TYPE");
      final List<Event> _result = new ArrayList<Event>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Event _item;
        _item = new Event();
        final int _tmpEvent_ID;
        _tmpEvent_ID = _cursor.getInt(_cursorIndexOfEventID);
        _item.setEvent_ID(_tmpEvent_ID);
        final String _tmpEVENT_CONTENT;
        _tmpEVENT_CONTENT = _cursor.getString(_cursorIndexOfEVENTCONTENT);
        _item.setEVENT_CONTENT(_tmpEVENT_CONTENT);
        final String _tmpEVENT_CREATEDATE;
        _tmpEVENT_CREATEDATE = _cursor.getString(_cursorIndexOfEVENTCREATEDATE);
        _item.setEVENT_CREATEDATE(_tmpEVENT_CREATEDATE);
        final String _tmpEVENT_CREATOR;
        _tmpEVENT_CREATOR = _cursor.getString(_cursorIndexOfEVENTCREATOR);
        _item.setEVENT_CREATOR(_tmpEVENT_CREATOR);
        final String _tmpEVENT_TITLE;
        _tmpEVENT_TITLE = _cursor.getString(_cursorIndexOfEVENTTITLE);
        _item.setEVENT_TITLE(_tmpEVENT_TITLE);
        final int _tmpEVENT_LEVEL;
        _tmpEVENT_LEVEL = _cursor.getInt(_cursorIndexOfEVENTLEVEL);
        _item.setEVENT_LEVEL(_tmpEVENT_LEVEL);
        final String _tmpPROCESSING_PEOPLE_DEPT;
        _tmpPROCESSING_PEOPLE_DEPT = _cursor.getString(_cursorIndexOfPROCESSINGPEOPLEDEPT);
        _item.setPROCESSING_PEOPLE_DEPT(_tmpPROCESSING_PEOPLE_DEPT);
        final String _tmpPROCESSING_PEOPLE_ID;
        _tmpPROCESSING_PEOPLE_ID = _cursor.getString(_cursorIndexOfPROCESSINGPEOPLEID);
        _item.setPROCESSING_PEOPLE_ID(_tmpPROCESSING_PEOPLE_ID);
        final String _tmpPROCESSING_PEOPLE_NAME;
        _tmpPROCESSING_PEOPLE_NAME = _cursor.getString(_cursorIndexOfPROCESSINGPEOPLENAME);
        _item.setPROCESSING_PEOPLE_NAME(_tmpPROCESSING_PEOPLE_NAME);
        final byte _tmpPROCESSING_TYPE;
        _tmpPROCESSING_TYPE = (byte) _cursor.getShort(_cursorIndexOfPROCESSINGTYPE);
        _item.setPROCESSING_TYPE(_tmpPROCESSING_TYPE);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Event getEvent(String eventID) {
    final String _sql = "SELECT * FROM LocalEvent WHERE Event_ID LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (eventID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, eventID);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfEventID = _cursor.getColumnIndexOrThrow("Event_ID");
      final int _cursorIndexOfEVENTCONTENT = _cursor.getColumnIndexOrThrow("EVENT_CONTENT");
      final int _cursorIndexOfEVENTCREATEDATE = _cursor.getColumnIndexOrThrow("EVENT_CREATEDATE");
      final int _cursorIndexOfEVENTCREATOR = _cursor.getColumnIndexOrThrow("EVENT_CREATOR");
      final int _cursorIndexOfEVENTTITLE = _cursor.getColumnIndexOrThrow("EVENT_TITLE");
      final int _cursorIndexOfEVENTLEVEL = _cursor.getColumnIndexOrThrow("EVENT_LEVEL");
      final int _cursorIndexOfPROCESSINGPEOPLEDEPT = _cursor.getColumnIndexOrThrow("PROCESSING_PEOPLE_DEPT");
      final int _cursorIndexOfPROCESSINGPEOPLEID = _cursor.getColumnIndexOrThrow("PROCESSING_PEOPLE_ID");
      final int _cursorIndexOfPROCESSINGPEOPLENAME = _cursor.getColumnIndexOrThrow("PROCESSING_PEOPLE_NAME");
      final int _cursorIndexOfPROCESSINGTYPE = _cursor.getColumnIndexOrThrow("PROCESSING_TYPE");
      final Event _result;
      if(_cursor.moveToFirst()) {
        _result = new Event();
        final int _tmpEvent_ID;
        _tmpEvent_ID = _cursor.getInt(_cursorIndexOfEventID);
        _result.setEvent_ID(_tmpEvent_ID);
        final String _tmpEVENT_CONTENT;
        _tmpEVENT_CONTENT = _cursor.getString(_cursorIndexOfEVENTCONTENT);
        _result.setEVENT_CONTENT(_tmpEVENT_CONTENT);
        final String _tmpEVENT_CREATEDATE;
        _tmpEVENT_CREATEDATE = _cursor.getString(_cursorIndexOfEVENTCREATEDATE);
        _result.setEVENT_CREATEDATE(_tmpEVENT_CREATEDATE);
        final String _tmpEVENT_CREATOR;
        _tmpEVENT_CREATOR = _cursor.getString(_cursorIndexOfEVENTCREATOR);
        _result.setEVENT_CREATOR(_tmpEVENT_CREATOR);
        final String _tmpEVENT_TITLE;
        _tmpEVENT_TITLE = _cursor.getString(_cursorIndexOfEVENTTITLE);
        _result.setEVENT_TITLE(_tmpEVENT_TITLE);
        final int _tmpEVENT_LEVEL;
        _tmpEVENT_LEVEL = _cursor.getInt(_cursorIndexOfEVENTLEVEL);
        _result.setEVENT_LEVEL(_tmpEVENT_LEVEL);
        final String _tmpPROCESSING_PEOPLE_DEPT;
        _tmpPROCESSING_PEOPLE_DEPT = _cursor.getString(_cursorIndexOfPROCESSINGPEOPLEDEPT);
        _result.setPROCESSING_PEOPLE_DEPT(_tmpPROCESSING_PEOPLE_DEPT);
        final String _tmpPROCESSING_PEOPLE_ID;
        _tmpPROCESSING_PEOPLE_ID = _cursor.getString(_cursorIndexOfPROCESSINGPEOPLEID);
        _result.setPROCESSING_PEOPLE_ID(_tmpPROCESSING_PEOPLE_ID);
        final String _tmpPROCESSING_PEOPLE_NAME;
        _tmpPROCESSING_PEOPLE_NAME = _cursor.getString(_cursorIndexOfPROCESSINGPEOPLENAME);
        _result.setPROCESSING_PEOPLE_NAME(_tmpPROCESSING_PEOPLE_NAME);
        final byte _tmpPROCESSING_TYPE;
        _tmpPROCESSING_TYPE = (byte) _cursor.getShort(_cursorIndexOfPROCESSINGTYPE);
        _result.setPROCESSING_TYPE(_tmpPROCESSING_TYPE);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
