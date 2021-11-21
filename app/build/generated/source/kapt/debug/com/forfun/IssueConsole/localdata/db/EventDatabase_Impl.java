package com.forfun.IssueConsole.localdata.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.forfun.IssueConsole.localdata.dao.LocalEventDAO;
import com.forfun.IssueConsole.localdata.dao.LocalEventDAO_Impl;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class EventDatabase_Impl extends EventDatabase {
  private volatile LocalEventDAO _localEventDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `LocalEvent` (`Event_ID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `EVENT_CONTENT` TEXT NOT NULL, `EVENT_CREATEDATE` TEXT NOT NULL, `EVENT_CREATOR` TEXT NOT NULL, `EVENT_TITLE` TEXT NOT NULL, `EVENT_LEVEL` INTEGER NOT NULL, `PROCESSING_PEOPLE_DEPT` TEXT NOT NULL, `PROCESSING_PEOPLE_ID` TEXT NOT NULL, `PROCESSING_PEOPLE_NAME` TEXT NOT NULL, `PROCESSING_TYPE` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"9c68cc29af12405eca4a6b856c776a4f\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `LocalEvent`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsLocalEvent = new HashMap<String, TableInfo.Column>(10);
        _columnsLocalEvent.put("Event_ID", new TableInfo.Column("Event_ID", "INTEGER", true, 1));
        _columnsLocalEvent.put("EVENT_CONTENT", new TableInfo.Column("EVENT_CONTENT", "TEXT", true, 0));
        _columnsLocalEvent.put("EVENT_CREATEDATE", new TableInfo.Column("EVENT_CREATEDATE", "TEXT", true, 0));
        _columnsLocalEvent.put("EVENT_CREATOR", new TableInfo.Column("EVENT_CREATOR", "TEXT", true, 0));
        _columnsLocalEvent.put("EVENT_TITLE", new TableInfo.Column("EVENT_TITLE", "TEXT", true, 0));
        _columnsLocalEvent.put("EVENT_LEVEL", new TableInfo.Column("EVENT_LEVEL", "INTEGER", true, 0));
        _columnsLocalEvent.put("PROCESSING_PEOPLE_DEPT", new TableInfo.Column("PROCESSING_PEOPLE_DEPT", "TEXT", true, 0));
        _columnsLocalEvent.put("PROCESSING_PEOPLE_ID", new TableInfo.Column("PROCESSING_PEOPLE_ID", "TEXT", true, 0));
        _columnsLocalEvent.put("PROCESSING_PEOPLE_NAME", new TableInfo.Column("PROCESSING_PEOPLE_NAME", "TEXT", true, 0));
        _columnsLocalEvent.put("PROCESSING_TYPE", new TableInfo.Column("PROCESSING_TYPE", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLocalEvent = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLocalEvent = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLocalEvent = new TableInfo("LocalEvent", _columnsLocalEvent, _foreignKeysLocalEvent, _indicesLocalEvent);
        final TableInfo _existingLocalEvent = TableInfo.read(_db, "LocalEvent");
        if (! _infoLocalEvent.equals(_existingLocalEvent)) {
          throw new IllegalStateException("Migration didn't properly handle LocalEvent(com.forfun.IssueConsole.localdata.model.Event).\n"
                  + " Expected:\n" + _infoLocalEvent + "\n"
                  + " Found:\n" + _existingLocalEvent);
        }
      }
    }, "9c68cc29af12405eca4a6b856c776a4f", "6fba87dc189cbbd33ba8f15f387e4f1a");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "LocalEvent");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `LocalEvent`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public LocalEventDAO getEventDao() {
    if (_localEventDAO != null) {
      return _localEventDAO;
    } else {
      synchronized(this) {
        if(_localEventDAO == null) {
          _localEventDAO = new LocalEventDAO_Impl(this);
        }
        return _localEventDAO;
      }
    }
  }
}
