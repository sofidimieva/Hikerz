export type User = {
    username: string;
    name: string;
    email: string;
    description: string;
    avatar_url: string;
    followers: User[];
    following: User[];
  };
  
  export type Paginated<T> = {
    data: T[];
    currentPage: number;
    totalPages: number;
  };
  
  import { Platform } from 'react-native';
  
  function resolveBaseUrl(raw: string) {
    // Android emulator can't reach host's "localhost"
    return Platform.OS === 'android' ? raw.replace('localhost', '10.0.2.2') : raw;
  }
  
  const BASE_URL = resolveBaseUrl(
    (process.env.EXPO_PUBLIC_API_BASE_URL as string) || 'http://localhost:8090'
  );
  
  function normalizePaginated<T>(raw: unknown, page: number, size: number): Paginated<T> {
    if (Array.isArray(raw)) {
      // backend returned a bare list
      return { data: raw as T[], currentPage: page, totalPages: 1 };
    }
    // try to read a standard paginated shape
    const r = raw as any;
    if (Array.isArray(r?.data)) {
      const cp = Number.isFinite(r.currentPage) ? r.currentPage : page;
      const tp = Number.isFinite(r.totalPages) ? r.totalPages : (cp === 0 ? 1 : cp + 1);
      return { data: r.data as T[], currentPage: cp, totalPages: tp };
    }
    // last resort: empty page
    return { data: [], currentPage: page, totalPages: 1 };
  }
  
  // services/userService.ts
  export async function fetchUsersPage(
    currentUsername: string,
    page: number,
    size: number,
    q?: string
  ): Promise<Paginated<User>> {
    const params = new URLSearchParams({
      page: String(page),
      size: String(size),
    });
    if (q && q.trim()) params.set('q', q.trim());
  
    const res = await fetch(
      `${BASE_URL}/api/user/all/${encodeURIComponent(currentUsername)}?${params.toString()}`,
      { headers: { Accept: 'application/json' } }
    );
    if (!res.ok) {
      const text = await res.text().catch(() => '');
      throw new Error(`GET /api/user/all failed: ${res.status} ${text}`);
    }
    return res.json();
  }
  
  
  
  export async function fetchUser(username: string): Promise<User> {
    const res = await fetch(`${BASE_URL}/api/user/single/${encodeURIComponent(username)}`, {
      headers: { Accept: 'application/json' },
    });
    if (!res.ok) {
      const text = await res.text().catch(() => '');
      throw new Error(`GET /api/user/${username} failed: ${res.status} ${text}`);
    }
    return res.json();
  }
  
  export async function followUser(username: string, target: string): Promise<void> {
    const url = `${BASE_URL}/api/follow/${encodeURIComponent(username)}/follow/${encodeURIComponent(target)}`;
    console.log(`[followUser] Sending POST request: ${url}`);
  
    try {
      const res = await fetch(url, { method: 'POST' });
      console.log(`[followUser] Response status: ${res.status}`);
  
      if (!res.ok) {
        const text = await res.text().catch(() => '');
        console.error(`[followUser] ❌ Failed: ${res.status} ${text}`);
        throw new Error(`POST follow failed: ${res.status} ${text}`);
      }
  
      console.log(`[followUser] ✅ Followed successfully: ${username} → ${target}`);
    } catch (err: any) {
      console.error(`[followUser] ⚠️ Exception:`, err);
      throw err;
    }
  }
  
  
  export async function unfollowUser(username: string, target: string): Promise<void> {
    const res = await fetch(
      `${BASE_URL}/api/follow/${encodeURIComponent(username)}/unfollow/${encodeURIComponent(target)}`,
      { method: 'DELETE' }
    );
    if (!res.ok) {
      const text = await res.text().catch(() => '');
      throw new Error(`DELETE unfollow failed: ${res.status} ${text}`);
    }
  }