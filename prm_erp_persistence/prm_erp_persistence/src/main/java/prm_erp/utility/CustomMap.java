package prm_erp.utility;

import java.util.ArrayList;
import java.util.List;

public class CustomMap<k, v> {

    private final int CAPACITY = 10;
    private boolean isExpirable = Boolean.FALSE;
    private long expiryTime = 0;

    public CustomMap() {
    }

    /**
     * ToDo: Set Expirable HashMap
     *
     * @param expiryTime
     */
    public CustomMap(long expiryTime) {
        this.expiryTime = expiryTime;
        this.isExpirable = Boolean.TRUE;
    }

    private final Entry<k, v>[] list = new Entry[CAPACITY];

    private class Entry<k, v> {

        k key;
        v value;
        long expiry;
        Entry<k, v> next;

        public Entry(k key, v value, long expiry) {
            this.key = key;
            this.value = value;
            this.expiry = expiry;
        }

        public Entry(k key, v value) {
            this.key = key;
            this.value = value;
        }
    }

    public void clear() {
        for (int i = 0; i < list.length; i++) {
            list[i] = null;
        }
    }

    public List<v> getAllValues() {
        long currentTimeMillis = System.currentTimeMillis();
        List<v> arrayList = new ArrayList<>();
        for (Entry<k, v> data : list) {
            if (null == data) {
                continue;
            }
            if (isExpirable) {
                long remainTime = currentTimeMillis - data.expiry;
                if (remainTime < this.expiryTime) {
                    arrayList.add(data.value);
                } else {
                    remove(data.key);
                }
            } else {
                arrayList.add(data.value);
            }
            while (null != data.next) {
                data = data.next;
                if (isExpirable) {
                    long remainTime = currentTimeMillis - data.expiry;
                    if (remainTime < this.expiryTime) {
                        arrayList.add(data.value);
                    } else {
                        remove(data.key);
                    }
                } else {
                    arrayList.add(data.value);
                }
            }
        }
        return arrayList;
    }

    public List<k> getAllKeys() {
        long currentTimeMillis = System.currentTimeMillis();
        List<k> arrayList = new ArrayList<>();
        for (Entry<k, v> data : list) {
            if (null == data) {
                continue;
            }
            if (isExpirable) {
                long remainTime = currentTimeMillis - data.expiry;
                if (remainTime < this.expiryTime) {
                    arrayList.add(data.key);
                } else {
                    remove(data.key);
                }
            } else {
                arrayList.add(data.key);
            }
            while (null != data.next) {
                data = data.next;
                if (isExpirable) {
                    long remainTime = currentTimeMillis - data.expiry;
                    if (remainTime < this.expiryTime) {
                        arrayList.add(data.key);
                    } else {
                        remove(data.key);
                    }
                } else {
                    arrayList.add(data.key);
                }
            }
        }
        return arrayList;
    }

    public int size() {
        return getAllKeys().size();
    }

    public List<k> containsValue(v val) {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<k> arrayList = new ArrayList<>();
        if (null == val) {
            return arrayList;
        }
        for (Entry<k, v> data : list) {
            if (null == data) {
                continue;
            }
            if (data.value.equals(val)) {
                if (isExpirable) {
                    long remainTime = currentTimeMillis - data.expiry;
                    if (remainTime < this.expiryTime) {
                        arrayList.add(data.key);
                        data.expiry = currentTimeMillis;
                    } else {
                        remove(data.key);
                    }
                } else {
                    arrayList.add(data.key);
                }
                continue;
            }
            while (null != data.next) {
                data = data.next;
                if (data.value.equals(val)) {
                    if (isExpirable) {
                        long remainTime = currentTimeMillis - data.expiry;

                        if (remainTime < this.expiryTime) {
                            arrayList.add(data.key);
                            data.expiry = currentTimeMillis;
                        } else {
                            remove(data.key);
                        }
                    } else {
                        arrayList.add(data.key);
                    }
                }
            }
        }
        return arrayList;
    }

    public Boolean containsKey(k key) {
        if (null == key) {
            return Boolean.FALSE;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int hashCode = getHashCode(key);
        Entry<k, v> data = list[hashCode];
        if (null != data) {
            if (data.key.equals(key)) {
                if (isExpirable) {
                    long remainTime = currentTimeMillis - data.expiry;
                    if (remainTime >= this.expiryTime) {
                        remove(data.key);
                        return Boolean.FALSE;
                    }
                    data.expiry = currentTimeMillis;
                }
                return Boolean.TRUE;
            }
        }
        while (null != data && null != data.next) {
            data = data.next;
            if (data.key.equals(key)) {
                if (isExpirable) {
                    long remainTime = currentTimeMillis - data.expiry;
                    if (remainTime >= this.expiryTime) {
                        remove(data.key);
                        return Boolean.FALSE;
                    }
                    data.expiry = currentTimeMillis;
                }
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public v get(k key) {
        if (null == key) {
            return null;
        }
        int hashCode = getHashCode(key);
        Entry<k, v> data = list[hashCode];
        if (null == data) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (data.key.equals(key)) {
            if (isExpirable) {
                long remainTime = currentTimeMillis - data.expiry;
                if (remainTime >= this.expiryTime) {
                    remove(data.key);
                    return null;
                }
                data.expiry = currentTimeMillis;
            }
            return (v) data.value;

        }
        while (null != data.next) {
            data = data.next;
            if (data.key.equals(key)) {
                if (isExpirable) {
                    long remainTime = currentTimeMillis - data.expiry;
                    if (remainTime >= this.expiryTime) {
                        remove(data.key);
                        return null;
                    }
                    data.expiry = currentTimeMillis;
                }
                return (v) data.value;
            }
        }
        return null;
    }

    public void put(k key, v value) {
        long currentTimeMillis = System.currentTimeMillis();
        if (null == key || null == value) {
            throw new NullPointerException("Key or Value must be not null");
        }
        int hashCode = getHashCode(key);
        Entry data = list[hashCode];
        if (null != data) {
            if (data.key.equals(key)) {
                data.value = value;
                data.expiry = currentTimeMillis;
                return;
            }
            while (null != data.next) {
                data = data.next;
                if (data.key.equals(key)) {
                    data.value = value;
                    data.expiry = currentTimeMillis;
                    return;
                }
            }
            data.next = new Entry(key, value, currentTimeMillis);
            return;
        }
        data = new Entry(key, value);
        list[hashCode] = data;
    }

    public List<Entry<k, v>> removeAll(List<k> key) {
        List<Entry<k, v>> arrayList = new ArrayList<>();
        if (null == key) {
            return arrayList;
        }
        key.forEach((k k) -> {
            arrayList.add(remove(k));
        });
        return arrayList;
    }

    public Entry<k, v> remove(k key) {

        if (null == key) {
            return null;
        }
        int hashCode = getHashCode(key);
        Entry data = list[hashCode];
        if (null != data) {
            if (data.key.equals(key)) {
                list[hashCode] = data.next;
                return data;
            }
            while (null != data.next) {
                if (data.next.key.equals(key)) {
                    Entry tmp = data.next;
                    data.next = data.next.next;
                    return tmp;
                }
                data = data.next;
            }
            return null;
        }
        return null;
    }

    private Boolean isExpired(Entry<k, v> e) {
        long currentTimeMillis = System.currentTimeMillis();
        if (isExpirable) {
            long remainTime = currentTimeMillis - e.expiry;
            if (remainTime >= this.expiryTime) {
                remove(e.key);
                return true;
            }
        }
        return false;
    }

    private int getHashCode(k key) {
        int hashCode = key.hashCode();
        hashCode = Math.abs(hashCode);
        hashCode %= CAPACITY;
        return hashCode;
    }
}
